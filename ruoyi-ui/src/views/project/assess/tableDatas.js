const editColumns = {
  title: '操作',
  dataIndex: 'edit',
  scopedSlots: {customRender: "edit"},
  fixed: 'right',
  width: 80
};
const idColumns = {
  title: '房号',
  dataIndex: 'idIndex',
  fixed: 'left',
  width: 80,
  scopedSlots: {customRender: "idIndex"},
};
const idsColumns = {
  title: '序号',
  dataIndex: 'idIndex',
  scopedSlots: {customRender: "idIndex"},
};
const paramColumns = [
  idColumns,
  {
    dataIndex: 'paramChName',
    title: '参数名称',
    scopedSlots: {customRender: "paramChName"}

  },
  {
    dataIndex: 'paramType',
    title: '参数类型',
    inputType: 'select',
    labelName: 'paramTypeName',
    valueName: 'paramType',
    scopedSlots: {customRender: "paramType"}
  },
  {
    dataIndex: 'paramDesc',
    title: '参数描述',
    scopedSlots: {customRender: "paramDesc"}

  },
  // editColumns
];
const streetEvaluation = [{
  dataIndex: '沿街商业房评估价格',
  title: '沿街商业房评估价格',
  children: [  {
    title: '基准价',
    dataIndex: 'benchmarkVO',
    scopedSlots: {customRender: "benchmarkVO"},
    width: 110,
  },{
    title: '用途修正系数',
    dataIndex: 'commercialUseCorrectionFactor',
    scopedSlots: {customRender: "commercialUseCorrectionFactor"},
    width: 110,
  },{
    title: '街道路线修正系数',
    dataIndex: 'commercialStreetCorrectionFactor',
    scopedSlots: {customRender: "commercialStreetCorrectionFactor"},
    width: 110,
  },{
    title: '实体修正系数1',
    dataIndex: 'stxzxs1',
    scopedSlots: {customRender: "stxzxs1"},
    width: 110,
  },{
    title: '实体修正系数2',
    dataIndex: 'stxzxs2',
    scopedSlots: {customRender: "stxzxs2"},
    width: 110,
  },{
    title: '实体修正系数3',
    dataIndex: 'stxzxs3',
    scopedSlots: {customRender: "stxzxs3"},
    width: 110,
  },{
    title: '实体修正系数',
    dataIndex: 'commercialEntityCorrectionFactor',
    scopedSlots: {customRender: "commercialEntityCorrectionFactor"},
    width: 110,
    disabled: true

  },{
    title: '年期修正系数',
    dataIndex: 'synxzxs',
    scopedSlots: {customRender: "synxzxs"},
    width: 110,
  },{
    title: '评估单价',
    dataIndex: 'sypgdj',
    scopedSlots: {customRender: "sypgdj"},
    width: 110,
    disabled: true

  },]
},]

const list = {
  baseInfo: {
    formColumns: [
      {
        title: '项目名称',
        dataIndex: 'projectName',
        wrapperCol: {span: 11.17},
        // inputType: 'select',
        disabled: true,
        // selectList: [],
      },
      {
        title: '房屋坐落',
        dataIndex: 'houseLocated',
        wrapperCol: {span: 11.17},
      },
      {
        title: '房屋产权人',
        dataIndex: 'propertyOwner',
      },
      {
        title: '产权证编号',
        dataIndex: 'titleCertificateNumber',
        placeholder: '请选择',
      },
      {
        title: '土地证号',
        dataIndex: 'landNumber',
        placeholder: '请选择',
      },
      {
        title: '房屋面积',
        dataIndex: 'floorSpace',
        disabled: true,
        placeholder: '待填报',
        inputType: 'inputNumber',
        step: 0.01
      },
      {
        dataIndex: 'managerContact',
        title: '土地面积',
      },
      {
        title: '估价时点',
        dataIndex: 'evaluateTime',
      },{
        title: '使用人',
        dataIndex: 'tenant',
      },{
        title: '记录员',
        dataIndex: 'registrar',
      },/*{
        title: '签收日期',
        dataIndex: 'lodgmentTime',
        inputType: 'datePicker',
      },*/{
        title: '评估员',
        dataIndex: 'evaluator',
        inputType: 'select',
        selectList: [],
      },{
        title: '估价师',
        dataIndex: 'valuer',
        inputType: 'select',
        selectList: [],
      },/*{
        title: '区位基准价',
        dataIndex: 'referencePrice',
      },*/{
        title: '报告编号',
        dataIndex: 'reportNumber',
      },{
        title: '报告年份',
        dataIndex: 'reportDate',
        inputType: 'datePicker',
        mode: 'year',
        dateFormat: 'YYYY'

      },{
        title: '报表样式',
        dataIndex: 'reportForm',
        inputType: 'select',
        selectList: [
          {
            text: '成套单元式住宅',
            value: 'tabColumns'
          },{
            text: '独门院落住宅',
            value: 'tab1'
          },{
            text: '非成套住宅',
            value: 'tab2'
          },{
            text: '非住宅营业',
            value: 'tab3'
          },{
            text: '非住宅非营业',
            value: 'tab4'
          },{
            text: '集体住宅',
            value: 'tab5'
          },{
            text: '江都评估表',
            value: 'tab6'
          }
        ],
      },{
        title: '住改非面积',
        dataIndex: 'zgfArea',
        inputType: 'inputNumber',
        disabled: true,

      },/*{
        title: '经营年限',
        dataIndex: 'manageYear',
        disabled: true,

      },*/{
        title: '单位统称',
        dataIndex: 'unitAs',

      },{
        title: '估价委托员',
        dataIndex: 'entrustingParty',
        disabled: true,
        // inputType: 'select',
        // selectList: [],
        wrapperCol: {span: 11.17},

      },{
        title: '报告标题',
        dataIndex: 'reportTitle',
        // inputType: 'select',
        // selectList: [],
        wrapperCol: {span: 11.17},

      },{
        title: '土地性质',
        dataIndex: 'landProperty',
        inputType: 'select',
        selectList: [],
      },/*{
        title: '区位级别',
        dataIndex: 'regionalLevel',
        inputType: 'select',
        selectList: [],
      },*//*{
        title: '结构等级',
        dataIndex: 'structureLevel',
        inputType: 'select',
        selectList: [],
      },*//*{
        title: '层次/总层',
        dataIndex: 'level',
      },*//*{
        title: '朝向',
        inputType: 'select',
        selectList: [],
        dataIndex: 'toward',
      },*/{
        title: '成套与否',
        inputType: 'select',
        selectList: [{
          text: '成套',
          value: '成套'
        },{
          text: '非成套',
          value: '非成套'
        },{
          text: '独立门院',
          value: '独立门院'
        },],
        dataIndex: 'isComplete',
      },{
        title: '地大于房单价',
        dataIndex: 'ddyfPrice',
      },{
        title: '地大于房面积',
        dataIndex: 'ddyfArea',

      },/*{
        title: '新建不满5年补偿%',
        dataIndex: 'xjbmwnCompensation',
      },*/

      {
        title: '土地用途',
        inputType: 'select',
        selectList: [
          {
            text: '住宅',
            value: 1
          },{
            text: '商业',
            value: 2
          },{
            text: '工业',
            value: 3
          },
        ],
        dataIndex: 'landUse',
      },/*{
        title: '容积率',
        dataIndex: 'plotratio',
        inputType: 'inputNumber',

      },*/{
        // title: '附着物前空行*1',
        dataIndex: 'planDesc1',
        inputType: 'inputNumber',
        disabled: true

      },{
        // title: '装修表格前空行*1',
        dataIndex: 'planDesc1',
        inputType: 'inputNumber',
        disabled: true
      },{
        title: '评估目的',
        dataIndex: 'evaluationPurpose',
      },{
        title: '评估单位',
        dataIndex: 'assessmentUnit',
      },{
        title: '土地重新取得价格',
        dataIndex: 'landGetPrice',
        inputType: 'inputNumber',
        disabled: true
      },{
        title: '土地使用权类型',
        dataIndex: 'planDesc1',
      },{
        title: '初审员',
        dataIndex: 'planDesc1',
      },{
        title: '表格备注',
        dataIndex: 'mark',
        inputType: 'textArea',
        wrapperCol: {span: 11.17}
      },
      // {
      //   title: '表格备注',
      //   dataIndex: 'tableNote',
      //   inputType: 'textArea',
      //   wrapperCol: {span: 13.9},
      // },
    ],
    tabColumns: [
      idColumns,

      {
        title: '建筑面积(m2)',
        dataIndex: 'area',
        rowSpan: 2,

        scopedSlots: {customRender: "total"},
        inputType: 'inputNumber',
        fixed: 'left',
        width: 100,
      },
      {
        title: '住改非面积',
        dataIndex: 'zgfArea',
        scopedSlots: {customRender: "zgfArea"},
        inputType: 'inputNumber',
        fixed: 'left',
        width: 100,
      },{
        title: '住宅房屋评估价格',
        dataIndex: '住宅房屋评估价格',
        scopedSlots: {customRender: "住宅房屋评估价格"},
        inputType: 'inputNumber',
        width: 100,
        children:[{
          title: '基准价格',
          dataIndex: 'benchmark',
          scopedSlots: {customRender: "benchmark"},
          width: 145,

        },{
          title: '分类调整系数',
          dataIndex: 'fltzxs',
          scopedSlots: {customRender: "fltzxs"},
          width: 120,
        },{
          title: '结构修正系数',
          dataIndex: 'structuralCorrectionFactor',
          scopedSlots: {customRender: "structuralCorrectionFactor"},
          width: 120,

        },{
          title: '成新修正系数',
          dataIndex: 'newCorrectionFactor',
          scopedSlots: {customRender: "newCorrectionFactor"},
          width: 120,

        },{
          title: '朝向修正系数',
          dataIndex: 'orientationCorrectionFactor',
          scopedSlots: {customRender: "orientationCorrectionFactor"},
          width: 120,

        },{
          title: '层次修正系数',
          dataIndex: 'levelCorrectionFactor',
          scopedSlots: {customRender: "levelCorrectionFactor"},
          width: 120,
        },{
          title: '实体状况修正系数',
          dataIndex: 'solidFactorCorrectionFactor',
          scopedSlots: {customRender: "solidFactorCorrectionFactor"},
          width: 120,
          disabled: true
        },
          {
            title: '扣减规费%',
            dataIndex: 'kjgf',
            scopedSlots: {customRender: "kjgf"},
            width: 110,
          },{
            title: '评估单价',
            dataIndex: 'evaluatePrice',
            scopedSlots: {customRender: "evaluatePrice"},
            width: 110,
            disabled: true
          },{
            title: '评估总价',
            dataIndex: 'pgzj',
            scopedSlots: {customRender: "pgzj"},
            width: 110,
            disabled: true
          },]
      } ,
      ...streetEvaluation,
     {
        title: '住宅权重',
        dataIndex: 'zzqz',
        scopedSlots: {customRender: "zzqz"},
        width: 110,
      },{
        title: '商业权重',
        dataIndex: 'syqz',
        scopedSlots: {customRender: "syqz"},
        width: 110,
      },{
        title: '住改非单价',
        dataIndex: 'zgfdj',
        scopedSlots: {customRender: "zgfdj"},
        width: 110,
        disabled: true

      },{
        title: '住改非折扣',
        dataIndex: 'zgfzk',
        scopedSlots: {customRender: "zgfzk"},
        width: 110,
      },{
        title: '沿街住改非增加',
        dataIndex: 'yjfzgfzj',
        scopedSlots: {customRender: "yjfzgfzj"},
        width: 110,
        disabled: true
      },
      editColumns,
      /* {
         title: '商业用途修正系数%',
         dataIndex: 'commercialUseCorrectionFactor',
         scopedSlots: {customRender: "commercialUseCorrectionFactor"},
         width: 110,
       },{
         title: '商业街道路线修正系数',
         dataIndex: 'commercialStreetCorrectionFactor',
         scopedSlots: {customRender: "commercialStreetCorrectionFactor"},
         width: 110,
       },{
         title: '商业用途实体修正系数',
         dataIndex: 'commercialEntityCorrectionFactor',
         scopedSlots: {customRender: "commercialEntityCorrectionFactor"},
         width: 110,
       // },*/
      //   title: '营业用房单价',
      //   dataIndex: 'unitPrice',
      //   inputType: 'inputNumber',
      //   scopedSlots: {customRender: "unitPrice"},
      //   width: 110,
      // },{
      //   title: '非住宅加权',
      //   dataIndex: 'nonresidentialWeightingw',
      //   scopedSlots: {customRender: "nonresidentialWeightingw"},
      //   width: 110,
      // },{
      //   title: '营业用房加权单价',
      //   dataIndex: 'weightedUnitPriceBusinessPremises',
      //   scopedSlots: {customRender: "weightedUnitPriceBusinessPremises"},
      //   width: 110,
      // },
    ],
    tab3: [
      idColumns,

      {
        title: '建筑面积(m2)',
        dataIndex: 'area',
        rowSpan: 2,
        scopedSlots: {customRender: "total"},
        inputType: 'inputNumber',
        width: 100,
      },
      {
        title: '住改非面积',
        dataIndex: 'zgfArea',
        scopedSlots: {customRender: "zgfArea"},
        inputType: 'inputNumber',
        width: 100,
      },
      ...streetEvaluation,
      {
        title: '评估总价',
        dataIndex: 'pgzj',
        scopedSlots: {customRender: "pgzj"},
        width: 110,
        disabled: true
      },
    ],
    tab4: [
      idColumns,

      {
        title: '建筑面积(m2)',
        dataIndex: 'area',
        rowSpan: 2,
        scopedSlots: {customRender: "total"},
        inputType: 'inputNumber',
        width: 100,
      },
      {
        title: '非改非面积',
        dataIndex: 'fgfArea',
        scopedSlots: {customRender: "fgfArea"},
        inputType: 'inputNumber',
        width: 100,
      },{
        title: '参考建安费',
        dataIndex: 'ckjaf',
        scopedSlots: {customRender: "ckjaf"},
        inputType: 'inputNumber',
        width: 100,
      },{
        title: '檐高调整系数',
        dataIndex: 'zgtzxs',
        scopedSlots: {customRender: "zgtzxs"},
        inputType: 'inputNumber',
        width: 100,
      },{
        title: '跨度修正系数',
        dataIndex: 'kdxzxs',
        scopedSlots: {customRender: "kdxzxs"},
        inputType: 'inputNumber',
        width: 100,
      },{
        title: '跨数修正系数',
        dataIndex: 'ksxzxs',
        scopedSlots: {customRender: "ksxzxs"},
        inputType: 'inputNumber',
        width: 100,
      },{
        title: '建安费',
        dataIndex: 'jaf',
        scopedSlots: {customRender: "jaf"},
        inputType: 'inputNumber',
        width: 100,
        disabled: true
      },{
        title: '重置价格',
        dataIndex: 'czPrice',
        scopedSlots: {customRender: "czPrice"},
        inputType: 'inputNumber',
        width: 100,
      },{
        title: '折旧',
        dataIndex: 'zjiu',
        scopedSlots: {customRender: "zjiu"},
        inputType: 'inputNumber',
        width: 100,
      },
      {
        title: '评估单价(元/m2)',
        dataIndex: 'evaluatePrice',
        scopedSlots: {customRender: "evaluatePrice"},
        inputType: 'inputNumber',
        step: 0.01,
        disabled: true,
        width: 110,
      },
      {
        title: '评估总价',
        dataIndex: 'pgzj',
        scopedSlots: {customRender: "pgzj"},
        width: 110,
        disabled: true
      },
      ...streetEvaluation,
      {
        title: '非住宅非营业权重',
        dataIndex: 'fzzfyyqz',
        scopedSlots: {customRender: "fzzfyyqz"},
        inputType: 'inputNumber',
        step: 0.01,
        width: 100,
      },{
        title: '商业权重',
        dataIndex: 'syqz',
        scopedSlots: {customRender: "syqz"},
        inputType: 'inputNumber',
        width: 100,
        step: 0.01,
      },{
        title: '土地单价',
        dataIndex: 'tdPrice',
        scopedSlots: {customRender: "tdPrice"},
        inputType: 'inputNumber',
        width: 100,
        step: 0.01,
      },{
        title: '非改非单价',
        dataIndex: 'fgfdj',
        scopedSlots: {customRender: "fgfdj"},
        width: 100,
        disabled: true,
        inputType: 'inputNumber',
        step: 0.01,
      },{
        title: '非改非折扣（默认100）',
        dataIndex: 'fgfzk',
        scopedSlots: {customRender: "fgfzk"},
        inputType: 'inputNumber',
        width: 100,
        step: 0.01,
      },{
        title: '沿街住改非增加',
        dataIndex: 'yjzfgfzj',
        scopedSlots: {customRender: "yjzfgfzj"},
        width: 100,
        disabled: true,
        inputType: 'inputNumber',
        step: 0.01,
      },
    ],
    tab6: [
      idColumns,
      {
        title: '建筑面积(m2)',
        dataIndex: 'total',
        scopedSlots: {customRender: "total"},
        inputType: 'inputNumber',
        step: 0.01,
      },
      {
        title: '重置价格(元/m2)',
        dataIndex: 'total',
        scopedSlots: {customRender: "total"},
        inputType: 'inputNumber',
        step: 0.01,
      }, {
        title: '房屋状况修正',
        dataIndex: 'total',
        scopedSlots: {customRender: "total"},
        inputType: 'inputNumber',
        step: 0.01,
      },{
        title: '层高修正',
        dataIndex: 'total',
        scopedSlots: {customRender: "total"},
        inputType: 'inputNumber',
        step: 0.01,
      },{
        title: '成新修正',
        dataIndex: 'total',
        scopedSlots: {customRender: "total"},
        inputType: 'inputNumber',
        step: 0.01,
      },{
        title: '评估单价(元/m2)',
        dataIndex: 'evaluatePrice',
        scopedSlots: {customRender: "evaluatePrice"},
        inputType: 'inputNumber',
        step: 0.01,
      },{
        title: '评估金额(元)',
        dataIndex: 'total',
        scopedSlots: {customRender: "total"},
        inputType: 'inputNumber',
        step: 0.01,
      },
    ],
    tab8: [
      idColumns,
      {
        title: '建筑面积(m2)',
        dataIndex: 'total',
        scopedSlots: {customRender: "total"},
        inputType: 'inputNumber',
        step: 0.01,
      },
      {
        title: '重置价格(元/m2)',
        dataIndex: 'total',
        scopedSlots: {customRender: "total"},
        inputType: 'inputNumber',
        step: 0.01,
      }, {
        title: '房屋状况修正',
        dataIndex: 'total',
        scopedSlots: {customRender: "total"},
        inputType: 'inputNumber',
        step: 0.01,
      },{
        title: '层高修正',
        dataIndex: 'total',
        scopedSlots: {customRender: "total"},
        inputType: 'inputNumber',
        step: 0.01,
      },{
        title: '成新修正',
        dataIndex: 'total',
        scopedSlots: {customRender: "total"},
        inputType: 'inputNumber',
        step: 0.01,
      },{
        title: '评估单价(元/m2)',
        dataIndex: 'evaluatePrice',
        scopedSlots: {customRender: "evaluatePrice"},
        inputType: 'inputNumber',
        step: 0.01,
      },{
        title: '评估金额(元)',
        dataIndex: 'total',
        scopedSlots: {customRender: "total"},
        inputType: 'inputNumber',
        step: 0.01,
      },
    ],
  },
  updateHouse: {
    tabColumns: [
      idColumns,
      {
        title: '建筑面积(m2)',
        dataIndex: 'area',
        scopedSlots: {customRender: "area"},
        inputType: 'inputNumber',
      },
      {
        title: '重置价格',
        dataIndex: 'houseNumber',
        scopedSlots: {customRender: "houseNumber"},

      },{
        title: '状况修正系数',
        dataIndex: 'conditionCorrectionFactor',
        scopedSlots: {customRender: "conditionCorrectionFactor"},
      },{
        title: '层高修正系数',
        dataIndex: 'heightCorrectionFactor',
        scopedSlots: {customRender: "heightCorrectionFactor"},
      },{
        title: '成新修正系数',
        dataIndex: 'newCorrectionCoefficient',
        scopedSlots: {customRender: "newCorrectionCoefficient"},
      },{
        title: '评估单价',
        dataIndex: 'evaluatePrice',
        scopedSlots: {customRender: "evaluatePrice"},
        inputType: 'inputNumber'
      },
      editColumns
    ],
    tabColumns1: [
      idColumns,
      {
        title: '住非改面积S3面积(m2)',
        dataIndex: 'nonRedevelopedArea',
        scopedSlots: {customRender: "nonRedevelopedArea"},
        inputType: 'inputNumber',
      },
      {
        title: '经营年限(年)',
        dataIndex: 'operationsDuration',
        scopedSlots: {customRender: "operationsDuration"},

      },{
        title: '非沿街住改非定额补助标准（元/m2）',
        dataIndex: 'nonStreetResidents',
        scopedSlots: {customRender: "nonStreetResidents"},
      },{
        title: '住非改增加补偿金额（元）',
        dataIndex: 'increaseAmountCompensation',
        scopedSlots: {customRender: "increaseAmountCompensation"},
      },
      editColumns
    ],
  },
  trimPrice: {
    tabColumns: [
      idsColumns,
      {
        title: '名称',
        dataIndex: 'name',
        scopedSlots: {customRender: "name"},
        inputType: 'select',
        selectList: [],
        labelName: 'name',
        valueName: 'id',
        valType: 'Number',
        allowClear: false
      },
      {
        title: '单价',
        dataIndex: 'unitPrice',
        scopedSlots: {customRender: "unitPrice"},
        wholeType: 'span'
      },{
        title: '公式',
        dataIndex: 'formula',
        width: 400,
        scopedSlots: {customRender: "formula"},
      },{
        title: '数量',
        dataIndex: 'number',
        scopedSlots: {customRender: "number"},

        wholeType: 'span'
      },{
        title: '成新率',
        dataIndex: 'newRate',
        scopedSlots: {customRender: "newRate"},
        inputType: 'inputNumber',
        width: 100
      },{
        title: '评估值',
        dataIndex: 'assessmentValue',
        scopedSlots: {customRender: "assessmentValue"},
        inputType: 'inputNumber',
        wholeType: 'span',
        step: 0.01
      },
      {
        title: '单位',
        dataIndex: 'unit',
        scopedSlots: {customRender: "unit"},
        wholeType: 'span'
      },{
        title: '房号',
        dataIndex: 'serialNumber',
        scopedSlots: {customRender: "serialNumber"},
      },
      editColumns
    ],
    tabColumns1: [
      idsColumns,
      {
        title: '名称',
        dataIndex: 'name',
        scopedSlots: {customRender: "name"},
        inputType: 'select',
        selectList: [],
        labelName: 'name',
        valueName: 'id',
        valType: 'Number',
        allowClear: false


      },
      {
        title: '单价',
        dataIndex: 'unitPrice',
        scopedSlots: {customRender: "unitPrice"},
        wholeType: 'span'
      },{
        title: '公式',
        dataIndex: 'formula',
        scopedSlots: {customRender: "formula"},
        width: 400,
      },{
        title: '数量',
        dataIndex: 'number',
        scopedSlots: {customRender: "number"},

        wholeType: 'span'
      },{
        title: '成新率',
        dataIndex: 'newRate',
        scopedSlots: {customRender: "newRate"},
        inputType: 'inputNumber',
        width: 100
      },{
        title: '评估值',
        dataIndex: 'assessmentValue',
        scopedSlots: {customRender: "assessmentValue"},
        inputType: 'inputNumber',
        wholeType: 'span',
        step: 0.01
      },
      {
        title: '单位',
        dataIndex: 'unit',
        scopedSlots: {customRender: "unit"},
        wholeType: 'span'
      },
      editColumns
    ]
  },
  twiceApply: {
    tabColumns: [
      idsColumns,
      {
        title: '分类名称',
        dataIndex: 'categoryName',
        scopedSlots: {customRender: "categoryName"},
        inputType: 'select',
        labelName: 'dictLabel',
        valueName: 'dictCode',
        selectList: [],
        valType: 'Number'
      },
      {
        title: '名称',
        dataIndex: 'name',
        scopedSlots: {customRender: "name"},
        inputType: 'select',
        selectList: [],
        labelName: 'name',
        valueName: 'id',
        valType: 'Number',
        allowClear: false
      },{
        title: '单价',
        dataIndex: 'unitPrice',
        step: 0.01,
        scopedSlots: {customRender: "unitPrice"},
        wholeType: 'span'
      },{
        title: '公式',
        dataIndex: 'formula',
        width: 400,
        scopedSlots: {customRender: "formula"},
      },{
        title: '数量',
        dataIndex: 'number',
        scopedSlots: {customRender: "number"},

        wholeType: 'span'
      },{
        title: '成新率',
        dataIndex: 'newRate',
        scopedSlots: {customRender: "newRate"},
        inputType: 'inputNumber',
        width: 100
      },{
        title: '评估值',
        dataIndex: 'assessmentValue',
        scopedSlots: {customRender: "assessmentValue"},
        inputType: 'inputNumber',
        wholeType: 'span',
        step: 0.01
      },
      {
        title: '单位',
        dataIndex: 'unit',
        scopedSlots: {customRender: "unit"},
        wholeType: 'span'
      },
      editColumns
    ],
    tabColumns1: [
      idsColumns,
      {
        title: '名称',
        dataIndex: 'name',
        scopedSlots: {customRender: "name"},
        inputType: 'select',
        selectList: [],
        labelName: 'name',
        valueName: 'id',
        valType: 'Number',
        allowClear: false
      },
      {
        title: '单价',
        dataIndex: 'unitPrice',
        scopedSlots: {customRender: "unitPrice"},
        wholeType: 'span'
      },{
        title: '公式',
        dataIndex: 'formula',
        width: 400,
        scopedSlots: {customRender: "formula"},
      },{
        title: '数量',
        dataIndex: 'number',
        scopedSlots: {customRender: "number"},

        wholeType: 'span'
      },{
        title: '成新率',
        dataIndex: 'newRate',
        scopedSlots: {customRender: "newRate"},
        inputType: 'inputNumber',
        width: 100
      },{
        title: '评估值',
        dataIndex: 'assessmentValue',
        scopedSlots: {customRender: "assessmentValue"},
        inputType: 'inputNumber',
        wholeType: 'span',
        step: 0.01
      },
      {
        title: '单位',
        dataIndex: 'unit',
        scopedSlots: {customRender: "unit"},
        wholeType: 'span'
      },{
        title: '房号',
        dataIndex: 'serialNumber',
        scopedSlots: {customRender: "serialNumber"},
      },
      editColumns
    ],
    tabColumns2: [
      idsColumns,
      {
        title: '名称',
        dataIndex: 'name',
        scopedSlots: {customRender: "name"},
        inputType: 'select',
        selectList: [],
        labelName: 'name',
        valueName: 'id',
        valType: 'Number',
        allowClear: false
      },
      {
        title: '单价',
        dataIndex: 'unitPrice',
        scopedSlots: {customRender: "unitPrice"},
        wholeType: 'span'
      },{
        title: '公式',
        dataIndex: 'formula',
        scopedSlots: {customRender: "formula"},
        width: 400,
      },{
        title: '数量',
        dataIndex: 'number',
        scopedSlots: {customRender: "number"},

        wholeType: 'span'
      },{
        title: '成新率',
        dataIndex: 'newRate',
        scopedSlots: {customRender: "newRate"},
        inputType: 'inputNumber',
        width: 100
      },{
        title: '评估值',
        dataIndex: 'assessmentValue',
        scopedSlots: {customRender: "assessmentValue"},
        inputType: 'inputNumber',
        wholeType: 'span',
        step: 0.01
      },
      {
        title: '单位',
        dataIndex: 'unit',
        scopedSlots: {customRender: "unit"},
        wholeType: 'span'
      },
      editColumns
    ]
  },
};
const getFormDatas = function (pageName) {
  return list[pageName];
}
export default getFormDatas;
