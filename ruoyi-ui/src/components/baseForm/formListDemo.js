import regExpConfig from '@/utils/regExpConfig';

export const formList = [
  {
    label: 'input',
    key: 'phone',
    widget: 'a-input',
    decoratorProps: {
      rules: [
        {
          required: true,
          message: '请输入手机号',
        },
        {
          pattern: regExpConfig.mobileCommon,
          message: '手机号格式不正确',
        },
      ],
    },
  },
  {
    label: 'select',
    key: 'email',
    widget: 'a-select',
    childWidget: 'a-select-option',
    children: [
      {
        name: '',
        value: ''
      }
    ],
    decoratorProps: {
      rules: [
        {
          required: true,
          message: '请选择',
        },
      ],
    },
  },
];
