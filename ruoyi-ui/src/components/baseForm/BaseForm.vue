<template>
  <div class="formWrapper" :class="layoutType">
    <div v-for="form in formList"
         v-bind="$attrs"
         :class="{'align_start': layoutType === 'vertical_form'}"
         class="flex align_center"
         :style="{width: `${(form.wrapperCol ? form.wrapperCol.span : (wrapperCol && wrapperCol.span)) / 24 * 100}%`}"
         :key="form.key">
      <label style="display: block"
             :class="{'ant-form-item-required': form.validateForm && form.validateForm.isRequire, 'disabled': form.disabled}"
             :style="{width: `${(form.hasOwnProperty('labelWidth') ? form.labelWidth : labelWidth)}px`}">{{form.title}}</label>
        <FormInput
                v-bind="{ wholeType, ...form }"
                v-model="formBind[form.dataIndex]"
        />
    </div>
  </div>
</template>

<script>
  import FormInput from '@/components/form/Input'
  export default {
    inheritAttrs: false,
    name: 'BaseForm',
    components: {FormInput},
    props: {
      formList: {
        type: Array,
        default: () => ([]),
      },
      labelWidth: {
        type: Number,
      },
      wrapperCol: {
        type: Object,
      },
      generateWidgetProps: {
        type: Function,
      },
      colon: {
        type: Boolean,
        default: true,
      },
      wholeType: {
        type: String,
        default: 'span',
      },
      formBind: {
        type: Object
      },
      layout: {
        type: String,
        default: 'inline'
      },

    },
    data() {
      return {
        // form: this.$form.createForm(this),
      };
    },
    computed: {
      layoutType() {
       return this.layout === 'inline' ? 'inline_form' : 'vertical_form'
      },
    },
    mounted() {},
    methods: {
      // computeFormItem() {
      //
      // },
      // mergeWidgetProps(form) {
      //   let defaultConfig = this.defaultWidgetProps1(form);
      //   if (this.generateWidgetProps) {
      //     defaultConfig = this.generateWidgetProps(form);
      //   }
      //   return {
      //     ...defaultConfig,
      //     ...form.widgetProps
      //   };
      // },
      // defaultWidgetProps1(form) {
      //   const defaultProps = { allowClear: true };
      //   defaultProps.placeholder = form.widget.includes('input')
      //     ?
      //     `请输入${form.label}`
      //     :
      //     `请输入${form.label}`;
      //   return defaultProps;
      // }
    },
  };
</script>

<style lang="scss" scoped>
  .formWrapper {
    padding: 10px;
    flex: 1;
    .disabled {
      color: grey;
    }
&>div {
  margin: 0 10px;
}
  }
  .inline_form {
    flex-grow: 1;
    flex-wrap: wrap;
    display: flex;
    -webkit-box-flex: 1;
    -ms-flex: 1;
    justify-content: space-between;
    flex-direction: row;
    align-items: center;
    & > div {
      margin: 2px 5px;
    }
  }
  .vertical_form {
    flex-direction: column;
    & > div {
      margin-bottom: 10px;
      margin-top: 10px;
    }

  }
  label {
    display: block !important;
    margin-right: 5px;
    flex-shrink:0;
    font-weight: 600;
    font-size: 14px;
    color: #606266;
    line-height:22px;
  }
</style>
