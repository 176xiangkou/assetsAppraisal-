<template>
  <div class="updateHouse">
      <editorTable :tabData.sync="tabObj[bItem.tabKey]"
                   :isEditor="isEditor"
                   v-for="bItem in tablesKey"
                   :nameObj="{label: bItem.label, button: '新增', tabBasePramas: {houseBaseId: projectObj.houseBaseId}}"
                   @change="onChange"
                   :columns="formList[bItem.columnKey]">
        <template slot-scope="{tableRow}"
                  v-for="(item, index) in formList[bItem.columnKey]"
                  :slot="item.scopedSlots.customRender">
          <FormInput
            v-if="item.scopedSlots.customRender !== 'edit'"
            :key="index"
            v-bind="{wholeType: isEditor ? 'input' : 'span', ...item}"
            v-model="tabObj[bItem.tabKey][tableRow.index][item.dataIndex]"
          />
        </template>
        <div slot="edit" slot-scope="{tableRow}"  class="edit" v-if="isEditor">
          <a @click="remove(bItem.tabKey,tableRow.index)">移除</a>
        </div>
      </editorTable>
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
  import {addNoPropertyMes, noPropertyMes, updateNoPropertyMes} from "../../../api/project/assess";
  export default {
    name: "updateHouse",
    components: {editorTable, BaseForm, FormInput},
    props: ['projectObj'],
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
    watch: {
      projectObj: {
        deep: true,
        handler() {
          this.noPropertyMes();
        }
      },
      'tabObj': {
        deep: true,
        handler(val) {
          Object.keys(val).map((key, index) => {
            if (val[key].length) {
              const tab = val[key];
              const endList = tab[tab.length - 1]
              const column = this.formList[this.tablesKey[index].columnKey].slice(1,7);
              let isHaveDataNum = 0;
              for (let item of column) {
                if (item.dataIndex && endList[item.dataIndex]) {
                  isHaveDataNum++;
                }
              }
              if (isHaveDataNum > 0) {
                this.tabObj[key].push({houseBaseId: this.projectObj.houseBaseId})
              }
            }
          })
        }
      }
      // 'tabObj.tabData': {
      //   deep: true,
      //   handler(val) {
      //     const values = Object.values(val[val.length - 1]).filter((s) => {
      //       return s !== ''
      //     });
      //     if (val.length && values.length > 1) {
      //       this.tabObj.tabData.push({houseBaseId: this.projectObj.houseBaseId})
      //     }
      //   }
      // },
      // 'tabObj.tabData1': {
      //   deep: true,
      //   handler(val) {
      //     const values = Object.values(val[val.length - 1]).filter((s) => {
      //       return s !== ''
      //     });
      //     if (val.length && values.length > 1) {
      //       this.tabObj.tabData1.push({houseBaseId: this.projectObj.houseBaseId})
      //     }
      //   }
      // },
    },
    methods: {
      submitAll(type) {
        const {tabData, tabData1} = this.tabObj;
        addNoPropertyMes({noPropertyHouseList: tabData, nonStreetHouseList: tabData1}).then(() => {
            this.$message.success('保存成功')
        })

      },
      remove(tabKey, index) {
        this.tabObj[tabKey].splice(index, 1);
        // this.addOrUpdate(this.modalTitle === '新增事件' ? 'add' : 'update', {'updateApi'})
      },
      selectRows(val) {
        console.log(val);

      },
      addNoPropertyMes(type, pramas) {
        const api = {
          addNoPropertyMes,
          updateNoPropertyMes,
          noPropertyMes
        }
        api[type]({...pramas, projectId: this.projectObj.id}).then(res => {
          if (type === 'noPropertyMes') return this.tabObj.tabData = res.data;
          let mes = '保存成功';
          if (type === 'updateNoPropertyMes') mes = '修改成功'
          else if (type === 'noPropertyMes') mes = null;
          mes && this.$message.success(mes);
        })

      },
      onChange() {},
      noPropertyMes() {
          noPropertyMes({houseBaseId: this.projectObj.houseBaseId}).then(res => {
            if (!res.data) return
              this.tabObj.tabData = res.data.noPropertyHouseList;
              this.tabObj.tabData1 = res.data.nonStreetHouseList;

          })
      },

    },
    created() {
      console.log(3454354, this.projectObj);

      const {type, id, categoryPid} = this.$route.query;
      if (type === 'detail') {
        this.wholeType = 'span';
        this.isEditor =false;
      }
      this.noPropertyMes();

    }
  }
</script>

<style scoped lang="scss">
</style>
