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
  import {decorateAttached, decorateAttachedList} from '@/api/project/assess'
  import {listPrice} from "../../../api/project/price";


  export default {
    name: "trimPrice",
    components: {editorTable, BaseForm, FormInput},
    props: ['projectObj'],
    data() {
      return {
        formList: getFormDatas('trimPrice'),
        wholeType: 'input',
        isEditor: true,
        formParams: {},
        tabObj: {
          tabData: [],
          tabData1: [],
        },
        tablesKey: [
          {
            label: '房装装修价格信息',
            tabKey: 'tabData',
            columnKey: 'tabColumns',
          },
          {
            label: '房屋附属价格信息',
            tabKey: 'tabData1',
            columnKey: 'tabColumns1',
          },
        ]
      }
    },
    watch: {
      projectObj: {
        deep: true,
        handler() {
          this.decorateAttachedList();
        }
      }
    },
    methods: {
      getDefaultHouseNum(key) {
        if (key === 'tabData') {
          const length = this.tabObj.tabData.length
          return  length ? this.tabObj.tabData[length-1].serialNumber : 1
        }
      },
      getTotal(tabKey, index, val, customRender) {
        let list = this.tabObj[tabKey][index];
        if (customRender === 'name') {
          // 切换名称改变单价和单位
          const slist = this.formList.tabColumns[0].selectList.find(item => {
            return item.id === val.val
          })
          this.tabObj[tabKey][index].unitPrice = slist ? slist.price : '';
          list.unitPrice = slist ? parseInt(slist.price) : '';
        }
        if (customRender === 'formula' || customRender === 'name') {
          try {
            if (customRender === 'formula') {
              this.tabObj[tabKey][index].number = eval(val)
              // else this.tabObj[tabKey][index].number = 0
            }
            if (list.unitPrice)
              this.tabObj[tabKey][index].assessmentValue = (list.number || 0) * list.unitPrice;
          } catch (e) {
          }
        }
      },
      submitAll() {
        const {tabData, tabData1} = this.tabObj;
         decorateAttached({attachedPriceHouseList: tabData1, decoratePriceHouseList: tabData}).then(() => {
           this.$message.success('保存成功')
         })
      },
       decorateAttachedList() {
        decorateAttachedList({houseBaseId: this.projectObj.houseBaseId}).then(res => {
            this.tabObj.tabData1 = res.data.attachedPriceHouseList
            this.tabObj.tabData = res.data.decoratePriceHouseList
        })
      },
      remove(tabKey, index) {
        this.tabObj[tabKey].splice(index, 1);
        // this.addOrUpdate(this.modalTitle === '新增事件' ? 'add' : 'update', {'updateApi'})
      },
      selectRows(val) {
        console.log(val);

      },
      onChange() {},
      getList() {
        listPrice().then(
          response => {
            this.formList.tabColumns[0].selectList = response.rows
            this.formList.tabColumns1[0].selectList = response.rows
          }
        );
      },

    },
    created() {
      console.log(3454354, this.tabData);
      const {type, id, categoryPid} = this.$route.query;
      if (type === 'detail') {
        this.wholeType = 'span';
        this.isEditor =false;
      }
      this.getList();
      this.decorateAttachedList();
    }
  }
</script>

<style scoped lang="scss">
  .trimPrice {

  }
</style>
