<template>
  <div class="formDetail">
    <p style="margin: 15px 0 0 15px" class="i_title">基本信息</p>
    <div style="width: 100%">
      <BaseForm :formList="formList.formColumns"
                :formBind.sync="formParams"
                style="justify-content: flex-start"
                :label-width="70"
                :wrapper-col="{span: 5.5}"
                :wholeType="'input'"/>
    </div>
    <!--<div class="main">-->
      <!--<editorTable :tabData.sync="tabData"-->
                   <!--:scroll="{ x: 980}"-->
                   <!--:isEditor="isEditor"-->
                   <!--:nameObj="{label: '房屋信息', button: '新增', tabBasePramas: {objectType: '文本'}}"-->
                   <!--@change="onChange"-->
                   <!--:columns="formList[formParams.reportForm]">-->
        <!--<template slot-scope="{tableRow}"-->
                  <!--v-for="(item, index) in formList[formParams.reportForm]"-->
                  <!--:slot="item.scopedSlots.customRender">-->
          <!--<FormInput-->
            <!--:whole-type="item.wholeType || (isEditor ? 'input' : 'span')"-->
            <!--v-if="item.scopedSlots.customRender !== 'edit'"-->
            <!--:key="index"-->
            <!--v-bind="item"-->
            <!--v-model="tabData[tableRow.index][item.dataIndex]"-->
          <!--/>-->
        <!--</template>-->
        <!--<div slot="edit" slot-scope="{tableRow}" class="edit" v-if="isEditor">-->
          <!--<a @click="remove(tableRow.index)">移除</a>-->
        <!--</div>-->
      <!--</editorTable>-->
    <!--</div>-->
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
  import {
    getHouseBaseArea,
    getNonStreetInfo,
    getProjectDetail,
    houseBaseAdd,
    updateHouseBase
  } from "../../../api/project/assess";
  import {getProject, listProject} from "../../../api/project/project";
  import {getDicts} from "../../../api/system/dict/data";
  import eventBus from "@/utils/eventBus";

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
        handler() {
          this.initData()
        }
      },
      tabData: {
        deep: true,
        handler(val) {
          this.$set(this.formParams, 'floorSpace', val.reduce((total, item) => {
            return total + (item.area || 0)
          }, 0))
          if (val.length) {
            const endList = val[val.length - 1]
            const column = this.formList.tabColumns.slice(0,18);
            let isHaveDataNum = 0;
            for (let item of column) {
              if (item.dataIndex && endList[item.dataIndex]) {
                isHaveDataNum++;
              }
            }
            if (isHaveDataNum > 0) {
              this.tabData.push({})
            }
          }
        }
      },
      'formParams.reportForm': function (val) {
        eventBus.$emit('reportFormChange', {data: val})
      }

    },
    methods: {
      submitAll() {
        const api = {
          'add': houseBaseAdd,
          'update': updateHouseBase
        };
        const {id} = this.formParams;
        api[id ? 'update' : 'add']({...this.formParams, houseInfo: null, onBaseInfo: 1}).then(() => {
          this.$message.success(id ? '修改信息成功！' : '新增信息成功！');
          this.$emit('changeStatus', false, true);
        })
      },
      remove(index) {
        this.tabData.splice(index, 1);
        // this.addOrUpdate(this.modalTitle === '新增事件' ? 'add' : 'update', {'updateApi'})
      },
      selectRows(val) {
        console.log(val);

      },
      onChange() {
      },
      getProjectDetail(houseBaseId) {
        console.log(56768768787);
        getProjectDetail({houseBaseId}).then(res => {
          const {house} = res;
          if (!house) return
          this.formParams = house;
          this.tabData = house.houseInfo
        })
      },
      getHouseBaseArea(houseBaseId) {
        getHouseBaseArea({houseBaseId}).then(res => {
          this.formParams.floorSpace = res.sumCount
        })
      },
      getNonStreetInfo(houseBaseId) {
        getNonStreetInfo({houseBaseId}).then(res => {
          this.formParams.zgfArea = res.data
        })
      },
      async initData() {
        if (this.projectObj) {
          const {id, label, houseBaseId, entrustName} = this.projectObj;
          if (houseBaseId) {
            await this.getHouseBaseArea(houseBaseId);
            this.getProjectDetail(houseBaseId);
            this.getNonStreetInfo(houseBaseId);
          }
          this.formParams = {reportForm: 'tabColumns'}
          this.tabData = []
          Object.assign(this.formParams, {'projectId': id, entrustingParty: entrustName, projectName: label})
          // this.$set(this.formParams, 'projectId', id);
          // this.$set(this.formParams, 'entrustingParty', id);
          // this.$set(this.formParams, 'projectName', label);
        }
      },

      getDicts(type) {
        const index = this.formList.formColumns.findIndex(item => {
          return item.dataIndex === type
        })
        if (index > -1)
          getDicts(type).then(res => {
           res.data.map(item => {
             const {dictLabel, dictValue} = item;
               item.text = dictLabel
               item.value = dictValue
           });
           this.formList.formColumns[index].selectList = res.data;
        })
      },
    },
    created() {
      this.initData();
      this.getDicts('regionalLevel');
      this.getDicts('landProperty');
      this.getDicts('toward');
      this.getDicts('structureLevel');
      this.getDicts('evaluator');
      this.getDicts('valuer');
      // this.getDicts('reportTitle');

    }
  }
</script>

<style scoped lang="scss">
  .formDetail {
    &::v-deep .ant-table td {
      white-space: nowrap;
    }
  }
</style>
