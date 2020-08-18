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
  export default {
    name: "trimPrice",
    components: {editorTable, BaseForm, FormInput},
    props: ['projectObj'],
    data() {
      return {
        formList: getFormDatas('twiceApply'),
        wholeType: 'input',
        isEditor: true,
        formParams: {},
        tabObj: {
          tabData: [],
        },
        tablesKey: [
          {
            label: '房屋其他及复核价格信息',
            tabKey: 'tabData',
            columnKey: 'tabColumns',
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
        let list = this.tabObj[tabKey][index]
        if (customRender === 'formula') {
          try {
            this.tabObj[tabKey][index].number = eval(val);
            if (list.unitPrice)
              this.tabObj[tabKey][index].assessmentValue = list.number * list.unitPrice;
          } catch (e) {
          }
        } else if (customRender === 'name') {
          // 切换名称改变单价和单位
        }

      },
      submitAll() {
         addCheck( this.tabObj.tabData).then(() => {
           this.$message.success('保存成功')
         })
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

    },
    created() {
      console.log(3454354, this.tabData);
      const {type, id, categoryPid} = this.$route.query;
      if (type === 'detail') {
        this.wholeType = 'span';
        this.isEditor =false;
      }
      this.getDicts("categoryName").then(response => {
        this.formList.tabColumns[0].selectList = response.data
      });
      this.checkList();

    }
  }
</script>

<style scoped lang="scss">
  .trimPrice {

  }
</style>
