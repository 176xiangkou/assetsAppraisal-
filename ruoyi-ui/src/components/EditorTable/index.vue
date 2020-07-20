<template>
  <a-row type="flex"
         :gutter="24"
         class="tabEditor"
         style="flex: 1;margin:24px 0">
    <a-col :span="24" v-if="$props.nameObj">
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
        :dataSource="tabData"
        :columns="columns"
        :locale="{emptyText: '暂无数据'}"
        style="width: 100%"
        :pagination="false"
        :rowKey="(record) => record.id"
        v-bind="$attrs"
        v-on="$listeners"
        :bordered="true"
      >
        <!-- 自定义表格渲染项 -->
        <template v-for="(colCustom, sindex) in columnsCustom" :slot="colCustom.customRender"
                  slot-scope="text, record, index">
          <span v-if="colCustom.customRender === 'idIndex'" :key="sindex">{{index + 1}}</span>
          <slot v-else-if="colCustom.customRender && $scopedSlots[colCustom.customRender]"
                :name="colCustom.customRender" :tableRow="{text, record, index}"></slot>
          <span v-else :key="sindex">{{record[colCustom.customRender]}}</span>
        </template>
      </a-table>
      <div class="page-footer" v-if="$attrs.pagination">
        <BasePagination :page-key.sync="$attrs.pagination.pageKey"
                        :get-list="$attrs.pagination.getList"></BasePagination>
      </div>
    </a-col>

  </a-row>
</template>

<script>
  import { Table, Col, Row, Icon } from 'ant-design-vue';
  export default {
    name: "editorTable",
    components: {
      'a-table': Table,
      'a-col': Col,
      'a-row': Row,
      'a-icon': Icon
    },
    props: {
      nameObj: {
        type: Object,
      },
      columns: [Array],
      tabData: [Array],
      isEditor: {
        type: Boolean,
        default: true
      },
      addTabs: [Function],
    },
    computed: {
      columnsCustom() {
        return this.columns.filter(item => {
          return item.scopedSlots
        }).map(item => item.scopedSlots)
      },
    },
    mounted() {
    },
    methods: {
      selectRows(val) {
        console.log(val);
      },
      addTab() {
        const {tabBasePramas} = this.nameObj
        let obj = {}
        this.columns.map(item => {
          obj[item.dataIndex] = ''
        })
        this.$emit('update:tabData', [...this.tabData, {...obj, ...tabBasePramas,}])
      },
    }
  }
</script>

<style scoped lang="scss">
  .ant-btn {
    margin: 7px 0 !important;
  }

  .tabEditor {
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
