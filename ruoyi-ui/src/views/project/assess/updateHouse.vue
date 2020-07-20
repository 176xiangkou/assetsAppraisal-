<template>
  <div class="updateHouse">
      <editorTable :tabData.sync="tabObj[bItem.tabKey]"
                   :isEditor="isEditor"
                   v-for="bItem in tablesKey"
                   :nameObj="{label: bItem.label, button: '新增'}"
                   @change="onChange"
                   :columns="formList[bItem.columnKey]">
        <template slot-scope="{tableRow}"
                  v-for="(item, index) in formList[bItem.columnKey]"
                  :slot="item.scopedSlots.customRender">
          <FormInput
            v-if="item.scopedSlots.customRender !== 'edit'"
            :key="index"
            v-bind="{wholeType: isEditor, ...item}"
            v-model="tabObj[bItem.tabKey][tableRow.index][item.dataIndex]"
          />
        </template>
        <div slot="edit" slot-scope="{tableRow}"  class="edit" v-if="isEditor">
          <a @click="remove(bItem.tabKey,tableRow.index)">移除</a>
        </div>
      </editorTable>
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
    name: "updateHouse",
    components: {editorTable, BaseForm, FormInput},
    data() {
      return {
        formList: getFormDatas('updateHouse'),
        wholeType: 'input',
        isEditor: true,
        formParams: {},
        tabObj: {
          tabData: [],
          tabData1: [],
        },
        tablesKey: [
          {
            label: '未确权房屋信息',
            tabKey: 'tabData',
            columnKey: 'tabColumns',
          },
          {
            label: '非沿街住改非房屋',
            tabKey: 'tabData1',
            columnKey: 'tabColumns1',
          },
        ]
      }
    },
    methods: {
      submitAll() {

      },
      remove(tabKey, index) {
        this.tabObj[tabKey].splice(index, 1);
        // this.addOrUpdate(this.modalTitle === '新增事件' ? 'add' : 'update', {'updateApi'})
      },
      selectRows(val) {
        console.log(val);

      },
      onChange() {},

    },
    created() {
      console.log(3454354, this.tabData);
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
</style>
