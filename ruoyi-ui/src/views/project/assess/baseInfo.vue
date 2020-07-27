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
                     :columns="formList[formParams.reportForm]">
          <template slot-scope="{tableRow}"
                    v-for="(item, index) in formList[formParams.reportForm]"
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
  import {getProjectDetail, houseBaseAdd, updateHouseBase} from "../../../api/project/assess";
  import {listProject} from "../../../api/project/project";
  export default {
    name: "formDetail",
    components: {editorTable, BaseForm, FormInput},
    props: ['projectObj'],
    data() {
      return {
        formList: getFormDatas('baseInfo'),
        tabData: [],
        wholeType: 'input',
        isEditor: true,
        formParams: {reportForm: 'tabColumns'},
      }
    },
    watch: {
      projectObj: {
        deep: true,
        handler(val) {
          if (val) {
            const {id, label, houseId} = val;
            if (houseId) return this.getProjectDetail(houseId);
            this.$set(this.formParams, 'projectId', id);
            this.$set(this.formParams, 'projectName', label);
          }
        }
      },
      tabData: {
        deep: true,
        handler(val) {
          this.$set(this.formParams, 'floorSpace', val.reduce((total, item) => {
            return total + (item.area || 0)
          }, 0))
        }
      },
      // 'formParams.tabClass': function (val) {
      //   this.tabKey
      // }

    },
    methods: {
      submitAll() {
        const api = {
          'add': houseBaseAdd,
          'update': updateHouseBase
        };
        const {id} = this.formParams;
        api[id ? 'update' : 'add']( {...this.formParams, houseInfo: this.tabData }).then(() => {
             this.$message.success(id ? '修改信息成功！' : '新增信息成功！');
             this.$emit('changeStatus', false);
        })
      },
      remove(index) {
        this.tabData.splice(index, 1);
        // this.addOrUpdate(this.modalTitle === '新增事件' ? 'add' : 'update', {'updateApi'})
      },
      selectRows(val) {
        console.log(val);

      },
      onChange() {},
      getProjectDetail(id) {
        getProjectDetail(id).then(res => {

        })
      }


    },
    created() {
      if (this.projectObj) {
        const {id, label, houseId} = this.projectObj;
        if (houseId) return this.getProjectDetail(houseId);
        this.$set(this.formParams, 'projectId', id);
        this.$set(this.formParams, 'projectName', label);
      }
    }
  }
</script>

<style scoped lang="scss">
  .formDetail {
    &::v-deep .ant-table td { white-space: nowrap; }
  }
</style>
