<template>
  <div class="trimPrice">
    <editorTable :tabData.sync="tabObj[bItem.tabKey]"
                 :isEditor="isEditor"
                 v-for="bItem in tablesKey"
                 :nameObj="{label: bItem.label, button: '新增', tabBasePramas: {houseBaseId: projectObj.houseBaseId, unit: '元/m2', newRate: 1, serialNumber: getDefaultHouseNum(bItem.tabKey)}}"
                 @change="onChange"
                 :columns="formList[bItem.columnKey]">
      <template slot-scope="{tableRow}"
                v-for="(item, index) in formList[bItem.columnKey]"
                :slot="item.scopedSlots.customRender">
        <FormInput
          v-if="item.scopedSlots.customRender !== 'edit'"
          :key="index"
          @change="(val) => getTotal(bItem.tabKey, tableRow.index, val, item.scopedSlots.customRender)"
          v-bind="{wholeType: isEditor ? 'input' : 'span', ...item}"
          v-model="tabObj[bItem.tabKey][tableRow.index][item.dataIndex]"
        />
      </template>
      <!--<FormInput-->
      <!--slot="gongshi" slot-scope="{tableRow}"-->
      <!--@change="(val) => getTotal(bItem.tabKey, tableRow.index, val)"-->
      <!--v-model="tabObj[bItem.tabKey][tableRow.index].gongshi"-->
      <!--/>-->
      <div slot="edit" slot-scope="{tableRow}"  class="edit" v-if="isEditor">
        <a @click="remove(bItem.tabKey,tableRow.index)">移除</a>
      </div>
    </editorTable>
    <div style="margin: 0 auto;display: block;text-align: center">
      <a-button type="primary" @click="submitAll()">保存</a-button>
    </div>
  </div>
</template>

<script>
  import getFormDatas from './tableDatas'
  import editorTable from "@/components/EditorTable/index";
  import FormInput from '@/components/form/Input'
  // import {getTemplateDetails, saveTemplateAndParams, updateTemplateAndParams} from "@/api/wuxing/formEdit";
  import BaseForm from "../../../components/baseForm/BaseForm";
  import {addCheck, checkList} from '@/api/project/assess'
  import {listPrice} from "../../../api/project/price";
  import trimPrice from './trimPrice'
  import {decorateAttached, decorateAttachedList} from "../../../api/project/assess";
  export default {
    name: "trimPrice",
    components: {editorTable, BaseForm, FormInput, trimPrice},
    props: ['projectObj'],
    data() {
      return {
        formList: getFormDatas('twiceApply'),
        wholeType: 'input',
        isEditor: true,
        formParams: {},
        tabObj: {
          tabData: [],
          tabData1: [],
          tabData2: [],
        },
        tablesKey: [
          {
            label: '房屋其他及复核价格信息',
            tabKey: 'tabData',
            columnKey: 'tabColumns',
          },   {
            label: '房装装修价格信息',
            tabKey: 'tabData1',
            columnKey: 'tabColumns1',
          },
          {
            label: '房屋附属价格信息',
            tabKey: 'tabData2',
            columnKey: 'tabColumns2',
          },
        ]
      }
    },
    watch: {
      projectObj: {
        deep: true,
        handler() {
          this.checkList();
        }
      },
      'tabObj': {
        deep: true,
        handler(val) {
          Object.keys(val).map((key, index) => {
            if (val[key].length) {
              const tab = val[key];
              const endList = tab[tab.length - 1]
              const column = this.formList[this.tablesKey[index].columnKey].slice(0,8);
              let isHaveDataNum = 0;
              for (let item of column) {
                if (item.dataIndex && endList[item.dataIndex]) {
                  isHaveDataNum++;
                }
              }
              if (isHaveDataNum > 2) {
                this.tabObj[key].push({houseBaseId: this.projectObj.houseBaseId, unit: '元/m2', newRate: 1, serialNumber: this.getDefaultHouseNum(key)})
              }
            }
          })
        }
      }
    },
    methods: {
      getDefaultHouseNum(key) {
        // if (key === 'tabData') {
          const length = this.tabObj[key].length
          return  length ? this.tabObj[key][length-1].serialNumber : 1
        // }
      },
      getTotal(tabKey, index, val, customRender) {
        let list = this.tabObj[tabKey][index];
        if (customRender === 'name') {
          // 切换名称改变单价和单位
          const slist = this.formList.tabColumns[2].selectList.find(item => {
            return item.id === val.val
          })
          this.tabObj[tabKey][index].unitPrice = slist ? slist.price : '';
          list.unitPrice = slist ? parseInt(slist.price) : '';
        }
        if (customRender === 'formula' || customRender === 'name') {
          console.log(index, val, customRender);

          try {
            if (customRender === 'formula') {
              this.$set(this.tabObj[tabKey], index, {...this.tabObj[tabKey][index], number: eval(val)})
            }
            if (list.unitPrice)
              this.tabObj[tabKey][index].assessmentValue = ((list.number || 0) * list.unitPrice).toFixed(2);
          } catch (e) {
          }
        }
      },
      async submitAll() {
         await addCheck( this.tabObj.tabData).then(() => {
         })
        await this.submitAllPrice();
      },
      remove(tabKey, index) {
        this.tabObj[tabKey].splice(index, 1);
        // this.addOrUpdate(this.modalTitle === '新增事件' ? 'add' : 'update', {'updateApi'})
      },
      selectRows(val) {
        console.log(val);

      },
      checkList() {
        checkList({houseBaseId: this.projectObj.houseBaseId}).then(res => {
           this.tabObj.tabData = res.data;
        })
      },
      onChange() {},
      getList() {
        listPrice().then(
          response => {
            this.formList.tabColumns[2].selectList = response.rows
          }
        );
      },
      getListPrice() {
        listPrice().then(
          response => {
            this.formList.tabColumns1[1].selectList = response.rows
            this.formList.tabColumns2[1].selectList = response.rows
          }
        );
      },
      decorateAttachedList() {
        decorateAttachedList({houseBaseId: this.projectObj.houseBaseId}).then(res => {
          this.tabObj.tabData2 = res.data.attachedPriceHouseList
          this.tabObj.tabData1 = res.data.decoratePriceHouseList
        })
      },
      submitAllPrice() {
        const {tabData1, tabData2} = this.tabObj;
        decorateAttached({attachedPriceHouseList: tabData2, decoratePriceHouseList: tabData1}).then(() => {
          this.$message.success('保存成功')
        })
      },
    },
    created() {
      const {type, id, categoryPid} = this.$route.query;
      if (type === 'detail') {
        this.wholeType = 'span';
        this.isEditor =false;
      }
      // if (this.$route.path === '/')
      this.getDicts("categoryName").then(response => {
        this.formList.tabColumns[1].selectList = response.data
      });
      this.getList();
      this.checkList();
      this.getListPrice();
      this.decorateAttachedList();

    }
  }
</script>

<style scoped lang="scss">
  .trimPrice {

  }
</style>
