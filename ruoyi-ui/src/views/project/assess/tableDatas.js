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

const list = {
  baseInfo: {

    formColumns: [
      {
        title: '项目名称',
        dataIndex: 'projectName',
        wrapperCol: {span: 9.2},
        // inputType: 'select',
        disabled: true,
        // selectList: [],
      },
      {
        title: '房屋坐落',
        dataIndex: 'houseLocated',
        wrapperCol: {span: 9.2},
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
        title: '承租人',
        dataIndex: 'tenant',
      },{
        title: '记录员',
        dataIndex: 'registrar',
      },{
        title: '签收日期',
        dataIndex: 'lodgmentTime',
        inputType: 'datePicker',
      },{
        title: '评估员',
        dataIndex: 'evaluator',
        inputType: 'select',
        selectList: [],
      },{
        title: '估价师',
        dataIndex: 'valuer',
        inputType: 'select',
        selectList: [],
      },{
        title: '区位基准价',
        dataIndex: 'referencePrice',
      },{
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
            text: '住宅',
            value: 'tabColumns'
          },{
            text: '非住宅非营业',
            value: 'tab1'
          },{
            text: '住改非',
            value: 'tab2'
          },{
            text: '非住宅营业',
            value: 'tab3'
          },{
            text: '江都评估表',
            value: 'tab4'
          },{
            text: '直管公房评估表',
            value: 'tab5'
          },{
            text: '非住宅非营业(不确权)',
            value: 'tab6'
          },{
            text: '非改非',
            value: 'tab7'
          },{
            text: '非住宅非营业(土地)',
            value: 'tab8'
          },
        ],
      },{
        title: '住改非面积',
        dataIndex: 'zgfArea',
        inputType: 'inputNumber',
        disabled: true,

      },{
        title: '经营年限',
        dataIndex: 'manageYear',
        disabled: true,

      },{
        title: '单位统称',
        dataIndex: 'unitAs',

      },{
        title: '委托方',
        dataIndex: 'entrustingParty',
        disabled: true,
        // inputType: 'select',
        // selectList: [],
        wrapperCol: {span: 9.2},

      },{
        title: '报告标题',
        dataIndex: 'reportTitle',
        // inputType: 'select',
        // selectList: [],
        wrapperCol: {span: 9.2},

      },{
        title: '土地性质',
        dataIndex: 'landProperty',
        inputType: 'select',
        selectList: [],
      },{
        title: '区位级别',
        dataIndex: 'regionalLevel',
        inputType: 'select',
        selectList: [],
      },{
        title: '结构等级',
        dataIndex: 'structureLevel',
        inputType: 'select',
        selectList: [],
      },{
        title: '层次/总层',
        dataIndex: 'level',
      },{
        title: '朝向',
        inputType: 'select',
        selectList: [],
        dataIndex: 'toward',
      },{
        title: '成套与否',
        inputType: 'select',
        selectList: [{
          text: '是',
          value: '是'
        },{
          text: '否',
          value: '否'
        },],
        dataIndex: 'isComplete',
      },{
        title: '地大于房单价',
        dataIndex: 'ddyfPrice',
      },{
        title: '地大于房面积',
        dataIndex: 'ddyfArea',

      },{
        title: '新建不满5年补偿%',
        dataIndex: 'xjbmwnCompensation',
      },

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
      },{
        title: '容积率',
        dataIndex: 'plotratio',
        inputType: 'inputNumber',

      },{
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
        title: '备注',
        dataIndex: 'mark',
        inputType: 'textArea',
        wrapperCol: {span: 9.2}
      },
      {
        title: '表格备注',
        dataIndex: 'tableNote',
        inputType: 'textArea',
        wrapperCol: {span: 13.9},
      },
    ],
    tabColumns: [
      {
        title: '房号',
        dataIndex: 'roomNumber',
        scopedSlots: {customRender: "roomNumber"},
      },
      {
        title: '面积(m2)',
        dataIndex: 'area',
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
      },
      {
        title: '基准价格',
        dataIndex: 'benchmark',
        scopedSlots: {customRender: "benchmark"},
        width: 145,

      },{
        title: '成套修正系数',
        dataIndex: 'setCorrectionFactor',
        scopedSlots: {customRender: "setCorrectionFactor"},
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
        title: '实体因素修正系数',
        dataIndex: 'solidFactorCorrectionFactor',
        scopedSlots: {customRender: "solidFactorCorrectionFactor"},
        width: 120,

      },{
        title: '产权人补偿%',
        dataIndex: 'tompensationPropertyOwner',
        scopedSlots: {customRender: "tompensationPropertyOwner"},
        width: 120,

      },{
        title: '承租人补偿%',
        dataIndex: 'tenantCompensation',
        scopedSlots: {customRender: "tenantCompensation"},
        width: 120,

      },
      // {
      //   title: '扣减规费%',
      //   dataIndex: 'templateDesc11',
      //   scopedSlots: {customRender: "createTime"},
      //   width: 110,
      // },
      {
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
      },{
        title: '营业用房单价',
        dataIndex: 'unitPrice',
        inputType: 'inputNumber',
        scopedSlots: {customRender: "unitPrice"},
        width: 110,
      },{
        title: '非住宅加权',
        dataIndex: 'nonresidentialWeightingw',
        scopedSlots: {customRender: "nonresidentialWeightingw"},
        width: 110,
      },{
        title: '营业用房加权单价',
        dataIndex: 'weightedUnitPriceBusinessPremises',
        scopedSlots: {customRender: "weightedUnitPriceBusinessPremises"},
        width: 110,
      },

      editColumns
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
        dataIndex: 'total',
        scopedSlots: {customRender: "total"},
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
        dataIndex: 'total',
        scopedSlots: {customRender: "total"},
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
        title: '面积(m2)',
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
      {
        title: '名称',
        dataIndex: 'name',
        scopedSlots: {customRender: "name"},
        inputType: 'select',
        selectList: []
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
      },{
        title: '数量',
        dataIndex: 'number',
        scopedSlots: {customRender: "number"},

        wholeType: 'span'
      },{
        title: '成新率',
        dataIndex: 'newRate',
        scopedSlots: {customRender: "newRate"},
        inputType: 'inputNumber'
      },{
        title: '评估值',
        dataIndex: 'assessmentValue',
        scopedSlots: {customRender: "assessmentValue"},
        inputType: 'inputNumber',
        wholeType: 'span',
        step: 0.0001
      },idsColumns,
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
      {
        title: '名称',
        dataIndex: 'name',
        scopedSlots: {customRender: "name"},
        inputType: 'select',
        selectList: []
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
      },{
        title: '数量',
        dataIndex: 'number',
        scopedSlots: {customRender: "number"},

        wholeType: 'span'
      },{
        title: '成新率',
        dataIndex: 'newRate',
        scopedSlots: {customRender: "newRate"},
        inputType: 'inputNumber'
      },{
        title: '评估值',
        dataIndex: 'assessmentValue',
        scopedSlots: {customRender: "assessmentValue"},
        inputType: 'inputNumber',
        wholeType: 'span',
        step: 0.0001
      },idsColumns,
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
      {
        title: '分类名称',
        dataIndex: 'categoryName',
        scopedSlots: {customRender: "categoryName"},
        inputType: 'select',
        labelName: 'dictLabel',
        valueName: 'dictCode',
        selectList: []
      },
      {
        title: '名称',
        dataIndex: 'name',
        scopedSlots: {customRender: "name"},
        inputType: 'select',
        selectList: []
      },{
        title: '单价',
        dataIndex: 'unitPrice',
        step: 0.01,
        scopedSlots: {customRender: "unitPrice"},
      },{
        title: '公式',
        dataIndex: 'formula',
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
        inputType: 'inputNumber'
      },{
        title: '评估值',
        dataIndex: 'assessmentValue',
        scopedSlots: {customRender: "assessmentValue"},
        inputType: 'inputNumber',
        wholeType: 'span',
        step: 0.0001
      },idsColumns,
      {
        title: '单位',
        dataIndex: 'unit',
        scopedSlots: {customRender: "unit"},
        wholeType: 'span'
      },
      editColumns
    ],
    tabColumns1: [
      {
        title: '名称',
        dataIndex: 'name',
        scopedSlots: {customRender: "name"},
        inputType: 'select',
        selectList: [
          {
            text: '名称1',
            value: 1,
          },{
            text: '名称2JAO',
            value: 2,
          },{
            text: '名称3wwJpi',
            value: 3,
          },
        ]
      },
      {
        title: '单价',
        dataIndex: 'price',
        scopedSlots: {customRender: "price"},
        wholeType: 'span'
      },{
        title: '公式',
        dataIndex: 'gongshi',
        scopedSlots: {customRender: "gongshi"},
      },{
        title: '数量',
        dataIndex: 'number',
        scopedSlots: {customRender: "number"},

        wholeType: 'span',
        width: 100
      },{
        title: '成新率',
        dataIndex: 'newRate',
        scopedSlots: {customRender: "newRate"},
        inputType: 'inputNumber'
      },{
        title: '评估值',
        dataIndex: 'values',
        scopedSlots: {customRender: "values"},
        inputType: 'inputNumber',
        wholeType: 'span',
        step: 0.4
      },idsColumns,
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
