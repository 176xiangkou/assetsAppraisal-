<template>
  <div class="main houseTab">
    <a-row type="flex"
           :gutter="24"
           class="tabEditor"
           style="flex: 1;margin:24px 0">
      <a-col :span="24" v-if="nameObj">
        <a-row type="flex" justify="space-between" align="middle">
          <span class="i_title">{{nameObj.label}}</span>
          <a-button @click="addTabs ? addTabs() : addTab()" v-if="isEditor" type="primary" ghost>
            <a-icon type="plus"/>
            {{nameObj.button || '新增'}}
          </a-button>
        </a-row>
      </a-col>
      <a-col :span="24">
      <a-table
      :scroll="{ x: 980}"
      :dataSource="tabData"
      :columns="formList[formParams.reportForm]"
      :locale="{emptyText: '暂无数据'}"
      style="width: 100%"
      :pagination="false"
      :rowKey="(record) => record.id"
      :bordered="true"
    >
      <!-- 自定义表格渲染项 -->
      <template slot-scope="text, record, index"
                v-for="(item, sindex) in columnsCustom()"
                :slot="item.scopedSlots ? item.scopedSlots.customRender : null">
        <FormInput
          :whole-type="item.wholeType || (isEditor ? 'input' : 'span')"
          v-if="item.scopedSlots.customRender !== 'edit'"
          :key="sindex"
          @change="(val, dataIndex) => inputChange(val, dataIndex, record)"
          v-bind="item"
          v-model="tabData[index][item.dataIndex]"
        />
      </template>
        <p slot="idIndex" slot-scope="text, record, index">{{index + 1}}</p>
      <div slot="edit" slot-scope="text, record" class="edit" v-if="isEditor">
        <a @click="remove(index)">移除</a>
      </div>
    </a-table>
    <div style="margin: 0 auto;display: block;text-align: center">
      <a-button type="primary" @click="submitAll()">保存</a-button>
    </div>
      </a-col>

    </a-row>
  </div>

</template>

<script>
  function formatNum(num) {
    return num === null || num === undefined || num === '' ? 0 : num
  }
  import { Table, Col, Row, Icon } from 'ant-design-vue';


  import getFormDatas from './tableDatas'
  import editorTable from "@/components/EditorTable/index";
  import eventBus from "@/utils/eventBus";
  import FormInput from '@/components/form/Input'
  // import {getTemplateDetails, saveTemplateAndParams, updateTemplateAndParams} from "@/api/wuxing/formEdit";
  import BaseForm from "../../../components/baseForm/BaseForm";
  import {getProjectDetail, houseBaseAdd, updateHouseBase} from "../../../api/project/assess";
  export default {
    name: "trimPrice",
    components: {editorTable, BaseForm, FormInput,  'a-table': Table,
      'a-col': Col,
      'a-row': Row,
      'a-icon': Icon},
    props: ['projectObj'],
    data() {
      return {
        nameObj: {label: '房屋信息', button: '新增', tabBasePramas: {objectType: '文本'}},
        tabData: [],
        isEditor: true,
        formList: getFormDatas('baseInfo'),
        formParams: {reportForm: 'tabColumns'},
        houseInfo: null
      }
    },
    watch: {
      projectObj: {
        deep: true,
        handler(val) {
          console.log('projectObj', val);
          const {houseBaseId} = val;
          if (houseBaseId) {
            this.getProjectDetail(houseBaseId);
          }

        }
      },
      tabData: {
        deep: true,
        handler(val) {
          if (val.length) {
            const endList = val[val.length - 1]
            const column = this.formList.tabColumns;
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
    },
    methods: {
      addTab() {
        const {tabBasePramas} = this.nameObj
        let obj = {}
        this.formList[this.formParams.reportForm].map(item => {
          obj[item.dataIndex] = ''
        })
        this.tabData = [...this.tabData, {...obj, ...tabBasePramas,}];
      },
      columnsCustom() {
        const arr = []
        console.log(this.formParams.reportForm);
        const columns  = this.formList[this.formParams.reportForm]
        const func = (columns) => columns.map(item => {
          if (item.children && item.children.length > 0) {
            return func(item.children)
          }
          if (item.scopedSlots) arr.push(item)
        })
        func(columns);
        return arr;
      },
      remove(index) {
        this.tabData.splice(index, 1);
        // this.addOrUpdate(this.modalTitle === '新增事件' ? 'add' : 'update', {'updateApi'})
      },
      submitAll() {
        const api = {
          'add': houseBaseAdd,
          'update': updateHouseBase
        };
        let data = JSON.parse(JSON.stringify(this.tabData));
        data.pop()
        const {id, houseBaseId} = this.projectObj;
        api[id ? 'update' : 'add']({id, houseBaseId, houseInfo: data, onBaseInfo: 0}).then(() => {
          this.$message.success(id ? '修改信息成功！' : '新增信息成功！');
          // this.$emit('changeStatus', false);
        })
      },
      inputChange(val, dataIndex, record) {
        console.log('change', record);
        console.log('dataIndex', dataIndex);
        console.log(this.houseInfo.reportForm);
        const formName = this.houseInfo.reportForm;
        const {levelCorrectionFactor, zgfzk, benchmarkVO, commercialUseCorrectionFactor, commercialStreetCorrectionFactor, zgfArea, zzqz, syqz, synxzxs, stxzxs1, stxzxs2, stxzxs3, structuralCorrectionFactor,  area, solidFactorCorrectionFactor, fltzxs, benchmark, newCorrectionFactor, orientationCorrectionFactor} = record;
        // 表格中公用沿街商业房评估价格可统一计算
        if ((formName === 'tabColumns' && record.zgfArea)  || formName === 'tab3' || formName === 'tab4' && record.fgfArea) {
          const commercialEntityCorrectionFactor = formatNum(stxzxs1) * formatNum(stxzxs2) * formatNum(stxzxs3);
          record.commercialEntityCorrectionFactor = commercialEntityCorrectionFactor
          record.sypgdj = formatNum(benchmarkVO) * formatNum(commercialUseCorrectionFactor) * formatNum(commercialStreetCorrectionFactor) * formatNum(commercialEntityCorrectionFactor) * formatNum(synxzxs)
        }
        // 住宅
        if (['tabColumns', 'tab1', 'tab2', 'tab5'].indexOf(this.houseInfo.reportForm) > -1) {
          const total = [structuralCorrectionFactor, newCorrectionFactor, orientationCorrectionFactor, levelCorrectionFactor].reduce((total, item, index) => {
            const indexMutiplyNum = [30, 20, 25, 25]
            if (item) total += item * indexMutiplyNum[index];
            return total;
          }, 0)
          const pingGuPrice = formatNum(benchmark) * formatNum(fltzxs) / 100 * formatNum(solidFactorCorrectionFactor) / 100;
          // 评估总价
          const totalPrice = (formatNum(pingGuPrice) * formatNum(area)).toFixed(2);
          record.solidFactorCorrectionFactor = (total / 100).toFixed(2);
          record.evaluatePrice = pingGuPrice;
          record.pgzj = totalPrice;
          if (record.zgfArea) {
            record.zgfdj = pingGuPrice * formatNum(zzqz) + pingGuPrice * formatNum(syqz)
            record.yjfzgfzj = pingGuPrice * formatNum(zzqz) + pingGuPrice * formatNum(syqz)
            record.yjfzgfzj = formatNum(zgfArea) * (formatNum(record.zgfdj) - formatNum(pingGuPrice)) * formatNum(zgfzk)
          }
        } else if (this.houseInfo.reportForm === 'tab3') {
          record.pgzj = formatNum(area) * formatNum(record.sypgdj)

        } else if (formName === 'tab4') {
          const { ckjaf, zgtzxs, kdxzxs, ksxzxs, czPrice, zjiu, fgfArea, tdPrice, fzzfyyqz, syqz, fgfzk } = record;
          record.jaf = ckjaf* (1 + formatNum(zgtzxs) + formatNum(kdxzxs) + formatNum(ksxzxs))
          record.evaluatePrice = formatNum(czPrice) - formatNum(zjiu)
          record.pgzj = formatNum(area) * formatNum(record.evaluatePrice)
          if (fgfArea) {
            record.fgfdj = (formatNum(record.evaluatePrice)+ formatNum(tdPrice)) * fzzfyyqz + formatNum(record.sypgdj) * syqz
            record.yjzfgfzj = formatNum(area) * (formatNum(record.fgfdj) - formatNum(record.evaluatePrice) - formatNum(tdPrice)) * fgfzk
          }
        }
      },
      matchColumns(reportForm) {
        switch (reportForm) {
          case 'tabColumns':
            this.formList.tabColumns.splice(8, 1, {
              title: '层次修正系数',
              dataIndex: 'levelCorrectionFactor',
              scopedSlots: {customRender: "levelCorrectionFactor"},
              width: 120,
            });
            break;
          case 'tab1':
            this.formList.tabColumns.splice(8, 1, {
              title: '平面布置系数',
              dataIndex: 'levelCorrectionFactor',
              scopedSlots: {customRender: "levelCorrectionFactor"},
              width: 120,
            });
            break;
          case 'tab2':
            this.formList.tabColumns.splice(8, 1, {
              title: '功能系数',
              dataIndex: 'levelCorrectionFactor',
              scopedSlots: {customRender: "levelCorrectionFactor"},
              width: 120,
            });
            break;
        }

      },
      async getProjectDetail(houseBaseId) {
        await getProjectDetail({houseBaseId}).then(res => {
          const {house} = res;
          if (!house) return
          this.formParams.reportForm = house.reportForm
          this.matchColumns(house.reportForm)
          this.tabData = house.houseInfo
          this.houseInfo = house
        })
      },
    },
    created() {
      const {houseBaseId} = this.projectObj;
      eventBus.$on('reportFormChange', (message) => {
        this.formParams.reportForm = message.data;
        this.matchColumns(message.data)

      })
      if (houseBaseId) {
        this.getProjectDetail(houseBaseId);
      }
    }
  }
</script>

<style scoped lang="scss">
  .trimPrice {

  }
  .houseTab {
    &::v-deep {
      .ant-table-tbody > tr > td {
        padding: 0 5px;
        height: 40px;
        overflow-wrap: break-word;
        .ant-input, .ant-input-number, .ant-select-selection, .ant-select-selection:focus, .ant-select-selection:active {
          border: none;
          box-shadow: none;
        }

        .ant-input-number-focused {
          box-shadow: none !important;
        }
      }
    }
  }
</style>
