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
        dataIndex: 'planName',
        wrapperCol: {span: 9.2},
        inputType: 'select',
        selectList: [],
      },
      {
        title: '房屋坐落',
        dataIndex: 'templateCode',
      },
      {
        title: '房屋产权人',
        dataIndex: 'planTypeId',
      },
      {
        title: '产权证编号',
        dataIndex: 'leadDeptName',
        placeholder: '请选择',
      },
      {
        title: '土地证号',
        dataIndex: 'planTopic',
        placeholder: '请选择',
      },
      {
        title: '房屋面积',
        dataIndex: 'total',
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
        dataIndex: 'planDesc',
      },{
        title: '承租人',
        dataIndex: 'planDesc1',
      },{
        title: '记录员',
        dataIndex: 'planDesc3',
      },{
        title: '签收日期',
        dataIndex: 'planDesc1',
      },{
        title: '评估员',
        dataIndex: 'planDesc1',
        inputType: 'select',
        selectList: [],
      },{
        title: '估价师',
        dataIndex: 'planDesc1',
        inputType: 'select',
        selectList: [],
      },{
        title: '区位基准价',
        dataIndex: 'planDesc1',
      },{
        title: '报告编号',
        dataIndex: 'planDesc1',
      },{
        title: '报告年份',
        dataIndex: 'planDesc1',
      },{
        title: '报表样式',
        dataIndex: 'planDesc1',
        inputType: 'select',
        selectList: [
          {
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
        dataIndex: 'planDesc1',
        inputType: 'inputNumber',
        disabled: true,

      },{
        title: '经营年限',
        dataIndex: 'planDesc1',
        disabled: true,

      },{
        title: '单位统称',
        dataIndex: 'planDesc1',

      },{
        title: '委托方',
        dataIndex: 'planDesc1',
        inputType: 'select',
        selectList: [],
        wrapperCol: {span: 9.2},

      },{
        title: '报告标题',
        dataIndex: 'planDesc1',
        inputType: 'select',
        selectList: [],
        wrapperCol: {span: 9.2},

      },{
        title: '土地性质',
        dataIndex: 'planDesc1',
        inputType: 'select',
        selectList: [],
      },{
        title: '区位级别',
        dataIndex: 'planDesc1',
        inputType: 'select',
        selectList: [],
      },{
        title: '结构等级',
        dataIndex: 'planDesc1',
        inputType: 'select',
        selectList: [],
      },{
        title: '层次/总层',
        dataIndex: 'planDesc1',
      },{
        title: '朝向',
        inputType: 'select',
        selectList: [],
        dataIndex: 'planDesc1',
      },{
        title: '成套与否',
        inputType: 'select',
        selectList: [],
        dataIndex: 'planDesc1',
      },{
        title: '地大于房单价',
        dataIndex: 'planDesc1',
      },{
        title: '地大于房面积',
        dataIndex: 'planDesc1',

      },{
        title: '新建不满5年补偿%',
        dataIndex: 'planDesc1',
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
        dataIndex: 'planDesc1',
      },{
        title: '容积率',
        dataIndex: 'planDesc1',
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
        dataIndex: 'planDesc1',
      },{
        title: '评估单位',
        dataIndex: 'planDesc1',
      },{
        title: '土地重新取得价格',
        dataIndex: 'planDesc1',
        inputType: 'inputNumber',
        disabled: true
      },{
        title: '备注',
        dataIndex: 'planDesc1',
        wrapperCol: {span: 9.2}
      },{
        title: '土地使用权类型',
        dataIndex: 'planDesc1',
      },{
        title: '初审员',
        dataIndex: 'planDesc1',
      },
      {
        title: '表格备注',
        dataIndex: 'planDesc1',
        inputType: 'textArea',
        wrapperCol: {span: 13.9},
      },
    ],
    tabColumns: [
      idColumns,
      {
        title: '面积(m2)',
        dataIndex: 'total',
        scopedSlots: {customRender: "total"},
        inputType: 'inputNumber',
        fixed: 'left',
        width: 100,
      },
      {
        title: '基准价格',
        dataIndex: 'templateDesc',
        scopedSlots: {customRender: "createTime"},
        width: 145,

      },{
        title: '成套修正系数',
        dataIndex: 'templateDesc1',
        scopedSlots: {customRender: "createTime"},
        width: 120,
      },{
        title: '结构修正系数',
        dataIndex: 'templateDesc1',
        scopedSlots: {customRender: "createTime"},
        width: 120,

      },{
        title: '成新修正系数',
        dataIndex: 'templateDesc1',
        scopedSlots: {customRender: "createTime"},
        width: 120,

      },{
        title: '朝向修正系数',
        dataIndex: 'templateDesc1',
        scopedSlots: {customRender: "createTime"},
        width: 120,

      },{
        title: '层次修正系数',
        dataIndex: 'templateDesc1',
        scopedSlots: {customRender: "createTime"},
        width: 120,

      },{
        title: '实体因素修正系数',
        dataIndex: 'templateDesc1',
        scopedSlots: {customRender: "createTime"},
        width: 120,

      },{
        title: '评估单价',
        dataIndex: 'templateDesc1',
        scopedSlots: {customRender: "createTime"},
        width: 100,

      },{
        title: '产权人补偿%',
        dataIndex: 'templateDesc1',
        scopedSlots: {customRender: "createTime"},
        width: 120,

      },{
        title: '承租人补偿%',
        dataIndex: 'templateDesc1',
        scopedSlots: {customRender: "createTime"},
        width: 120,

      },{
        title: '扣减规费%',
        dataIndex: 'templateDesc1',
        scopedSlots: {customRender: "createTime"},
        width: 110,
      },
      editColumns
    ],
  },
  updateHouse: {
    tabColumns: [
      idColumns,
      {
        title: '面积(m2)',
        dataIndex: 'templateStatus',
        scopedSlots: {customRender: "templateStatus"},
        inputType: 'inputNumber',
      },
      {
        title: '重置价格',
        dataIndex: 'templateDesc',
        scopedSlots: {customRender: "createTime"},

      },{
        title: '状况修正系数',
        dataIndex: 'templateDesc1',
        scopedSlots: {customRender: "createTime"},
      },{
        title: '层高修正系数',
        dataIndex: 'templateDesc1',
        scopedSlots: {customRender: "createTime"},
      },{
        title: '成新修正系数',
        dataIndex: 'templateDesc1',
        scopedSlots: {customRender: "createTime"},
      },{
        title: '评估单价',
        dataIndex: 'templateDesc1',
        scopedSlots: {customRender: "createTime"},
        inputType: 'inputNumber'
      },
      editColumns
    ],
    tabColumns1: [
      idColumns,
      {
        title: '住非改面积S3面积(m2)',
        dataIndex: 'templateStatus',
        scopedSlots: {customRender: "templateStatus"},
        inputType: 'inputNumber',
      },
      {
        title: '经营年限(年)',
        dataIndex: 'templateDesc',
        scopedSlots: {customRender: "createTime"},

      },{
        title: '非沿街住改非定额补助标准（元/m2）',
        dataIndex: 'templateDesc1',
        scopedSlots: {customRender: "createTime"},
      },{
        title: '住非改增加补偿金额（元）',
        dataIndex: 'templateDesc1',
        scopedSlots: {customRender: "createTime"},
      },
      editColumns
    ],
  },
  trimPrice: {
    tabColumns: [
      {
        title: '名称',
        dataIndex: 'templateStatus',
        scopedSlots: {customRender: "templateStatus"},
        inputType: 'select',
        selectList: []
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

        wholeType: 'span'
      },{
        title: '成新率',
        dataIndex: 'templateDesc1',
        scopedSlots: {customRender: "createTime1"},
        inputType: 'inputNumber'
      },{
        title: '评估值',
        dataIndex: 'values',
        scopedSlots: {customRender: "values"},
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
        dataIndex: 'houseNum',
        scopedSlots: {customRender: "houseNum"},
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

        wholeType: 'span'
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
