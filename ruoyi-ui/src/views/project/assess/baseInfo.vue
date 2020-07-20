<template>
  <div class="formDetail">
    <p style="margin: 15px 0 0 15px" class="i_title">基本信息</p>
    <div style="width: 100%">
      <BaseForm :formList="formList.formColumns"
                :formBind.sync="formParams"
                style="justify-content: flex-start"
                :label-width="70"
                :wrapper-col="{span: 4.5}"
                :wholeType="'input'"/>
    </div>
    <div class="main">
      <editorTable :tabData.sync="tabData"
                   :scroll="{ x: 980}"
                     :isEditor="isEditor"
                     :nameObj="{label: '房屋信息', button: '新增', tabBasePramas: {objectType: '文本'}}"
                     @change="onChange"
                     :columns="formList[formParams.tabClass]">
          <template slot-scope="{tableRow}"
                    v-for="(item, index) in formList[formParams.tabClass]"
                    :slot="item.scopedSlots.customRender">
            <FormInput
              :whole-type="item.wholeType || (isEditor ? 'input' : 'span')"
              v-if="item.scopedSlots.customRender !== 'edit'"
              :key="index"
              v-bind="item"
              v-model="tabData[tableRow.index][item.dataIndex]"
            />
          </template>
          <div slot="edit" slot-scope="{tableRow}"  class="edit" v-if="isEditor">
            <a @click="remove(tableRow.index)">移除</a>
          </div>
        </editorTable>
    </div>
    <div style="margin: 0 auto;display: block;text-align: center">
      <a-button type="primary" @click="submitAll">保存</a-button>
    </div>
  </div>
</template>

<script>
  import getFormDatas from './tableDatas'
  import editorTable from "@/components/EditorTable/index";
  import FormInput from '@/components/form/Input'
  // import {getTemplateDetails, saveTemplateAndParams, updateTemplateAndParams} from "@/api/wuxing/formEdit";
  import BaseForm from "../../../components/baseForm/BaseForm";
  export default {
    name: "formDetail",
    components: {editorTable, BaseForm, FormInput},
    data() {
      return {
        formList: getFormDatas('baseInfo'),
        tabData: [],
        wholeType: 'input',
        isEditor: true,
        formParams: {tabClass: 'tabColumns'},
      }
    },
    watch: {
      tabData: {
        deep: true,
        handler(val) {
          this.$set(this.formParams, 'total', val.reduce((total, item) => {
            return total + (item.total || 0)
          }, 0))
        }
      },
      // 'formParams.tabClass': function (val) {
      //   this.tabKey
      // }

    },
    methods: {
      submitAll() {

      },
      remove(index) {
        this.tabData.splice(index, 1);
        // this.addOrUpdate(this.modalTitle === '新增事件' ? 'add' : 'update', {'updateApi'})
      },
      selectRows(val) {
        console.log(val);

      },
      onChange() {},

    },
    created() {
      const {type, id, categoryPid} = this.$route.query;
      if (type === 'detail') {
        this.wholeType = 'span';
        this.isEditor =false;
      }
      if (categoryPid) this.formParams = {categoryPid, id: 0};
      if (id) this.getList(id);
    }
  }
</script>

<style scoped lang="scss">
  .formDetail {
    &::v-deep .ant-table td { white-space: nowrap; }
  }
</style>
