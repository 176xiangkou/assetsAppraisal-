<template>
  <div class="app-container">
    <el-row :gutter="20">
      <!--部门数据-->
      <el-col :span="4" :xs="24">
        <div class="head-container">
          <el-input
            v-model="deptName"
            placeholder="请输入项目名称"
            clearable
            size="small"
            prefix-icon="el-icon-search"
            style="margin-bottom: 20px"
          />
        </div>
        <div class="head-container">
          {{selectId}}
          <el-tree
            :current-node-key="projectObj.id"
            :highlight-current="true"
            :data="deptOptions"
            :props="defaultProps"
            :expand-on-click-node="false"
            :filter-node-method="filterNode"
            ref="tree"
            node-key="id"
            default-expand-all
            @node-click="handleNodeClick"
          />
        </div>
      </el-col>
      <!--用户数据-->
      <el-col :span="20" :xs="24">
        <el-form :model="queryParams" ref="queryForm" :inline="true" label-width="68px">
          <el-form-item label="查询字段" prop="userName">
            <el-input
              v-model="queryParams.userName"
              placeholder="请输入查询内容"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item>
            <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
            <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
          </el-form-item>
          <el-form-item>
            <el-row :gutter="10" class="mb8">
              <el-col :span="1.5">
                <el-button
                  type="primary"
                  icon="el-icon-plus"
                  size="mini"
                  :disabled="!projectObj.id"
                  @click="handleAdd"
                  v-hasPermi="['system:user:add']"
                >新增
                </el-button>
              </el-col>
              <!--<el-col :span="1.5">-->
              <!--<el-button-->
              <!--type="success"-->
              <!--icon="el-icon-edit"-->
              <!--size="mini"-->
              <!--:disabled="single"-->
              <!--@click="handleUpdate"-->
              <!--v-hasPermi="['system:user:edit']"-->
              <!--&gt;修改</el-button>-->
              <!--</el-col>-->
              <el-col :span="1.5">
                <el-button
                  type="danger"
                  icon="el-icon-delete"
                  size="mini"
                  :disabled="multiple"
                  @click="handleDelete()"
                  v-hasPermi="['system:user:remove']"
                >删除
                </el-button>
              </el-col>
              <!--<el-col :span="1.5">-->
              <!--<el-button-->
              <!--type="info"-->
              <!--icon="el-icon-upload2"-->
              <!--size="mini"-->
              <!--@click="handleImport"-->
              <!--v-hasPermi="['system:user:import']"-->
              <!--&gt;导入</el-button>-->
              <!--</el-col>-->
              <!--<el-col :span="1.5">-->
              <!--<el-button-->
              <!--type="warning"-->
              <!--icon="el-icon-download"-->
              <!--size="mini"-->
              <!--@click="handleExport"-->
              <!--v-hasPermi="['system:user:export']"-->
              <!--&gt;导出</el-button>-->
              <!--</el-col>-->
            </el-row>

          </el-form-item>
        </el-form>
        <el-table row-class-name="trClass" v-loading="loading" :data="userList" @selection-change="handleSelectionChange" @row-dblclick="dbClick">
          <el-table-column type="selection" width="40" align="center"/>
          <el-table-column label="编号" align="center" width="50" prop="id"/>
          <el-table-column label="项目名称" width="200" align="center" prop="projectName"/>
          <el-table-column label="估价委托员" width="150" align="center" prop="entrustingParty"/>
          <el-table-column label="产权人" align="center" prop="propertyOwne" :show-overflow-tooltip="true"/>
          <el-table-column label="坐落" align="center" prop="houseLocated" width="120"/>
          <el-table-column label="建筑面积" align="center" prop="floorSpace" width="120"/>
          <el-table-column label="估价金额" align="center" prop="referencePrice" width="120"/>
          <el-table-column label="时间" align="center" prop="createTime" width="160">
            <template slot-scope="scope">
              <span>{{ parseTime(scope.row.createTime) }}</span>
            </template>
          </el-table-column>
          <el-table-column
            label="操作"
            align="center"
            width="180"
            class-name="small-padding fixed-width"
          >
            <template slot-scope="scope">
              <el-button
                size="mini"
                type="text"
                icon="el-icon-edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['system:user:edit']"
              >修改
              </el-button>
              <el-button
                v-if="scope.row.userId !== 1"
                size="mini"
                type="text"
                icon="el-icon-delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:user:remove']"
              >删除
              </el-button>
              <!--<el-button-->
              <!--size="mini"-->
              <!--type="text"-->
              <!--icon="el-icon-key"-->
              <!--@click="handleResetPwd(scope.row)"-->
              <!--v-hasPermi="['system:user:resetPwd']"-->
              <!--&gt;重置</el-button>-->
            </template>
          </el-table-column>
        </el-table>

        <pagination
          v-show="total>0"
          :total="total"
          :page.sync="queryParams.pageNum"
          :limit.sync="queryParams.pageSize"
          @pagination="getList"
        />
      </el-col>
    </el-row>
    <a-modal
      :destroyOnClose="true"
      wrapClassName="newProjectDio"
      :title="title"
      :footer="null"
      :visible.sync="open"
      @ok="handleOk"
      @cancel="() => closeModal()"
    >
      <assess :projectObj="projectObj" @changeStatus="changeStatus"/>
    </a-modal>
    <!-- 添加或修改参数配置对话框 -->
    <!--<el-dialog :title="title" custom-class="newProjectDio" :visible.sync="open" :width="'90vw'">-->
    <!--<assess />-->
    <!--<div slot="footer" class="dialog-footer">-->
    <!--<el-button type="primary">确 定</el-button>-->
    <!--<el-button>取 消</el-button>-->
    <!--</div>-->
    <!--</el-dialog>-->

    <!-- 用户导入对话框 -->
    <el-dialog :title="upload.title" :visible.sync="upload.open" width="400px">
      <el-upload
        ref="upload"
        :limit="1"
        accept=".xlsx, .xls"
        :headers="upload.headers"
        :action="upload.url + '?updateSupport=' + upload.updateSupport"
        :disabled="upload.isUploading"
        :on-progress="handleFileUploadProgress"
        :on-success="handleFileSuccess"
        :auto-upload="false"
        drag
      >
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">
          将文件拖到此处，或
          <em>点击上传</em>
        </div>
        <div class="el-upload__tip" slot="tip">
          <el-checkbox v-model="upload.updateSupport"/>
          是否更新已经存在的用户数据
          <el-link type="info" style="font-size:12px" @click="importTemplate">下载模板</el-link>
        </div>
        <div class="el-upload__tip" style="color:red" slot="tip">提示：仅允许导入“xls”或“xlsx”格式文件！</div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFileForm">确 定</el-button>
        <el-button @click="upload.open = false">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import {
    listUser,
    getUser,
    delUser,
    addUser,
    updateUser,
    exportUser,
    resetUserPwd,
    changeUserStatus,
    importTemplate
  } from "@/api/system/user";
  import {getToken} from "@/utils/auth";
  import {treeselect} from "@/api/system/dept";
  import Treeselect from "@riophae/vue-treeselect";
  import "@riophae/vue-treeselect/dist/vue-treeselect.css";
  import assess from '../assess/assess'
  import {listProject} from "../../../api/project/project";
  import {getHouseBaseById, houseBaseDelete} from "../../../api/project/assess";

  export default {
    name: "User",
    components: {Treeselect, assess},
    data() {
      return {
        projectObj: {},
        // 遮罩层
        loading: false,
        // 选中数组
        ids: [],
        // 非单个禁用
        single: true,
        // 非多个禁用
        multiple: true,
        // 总条数
        total: 0,
        // 用户表格数据
        userList: null,
        // 弹出层标题
        title: "",
        // 部门树选项
        deptOptions: undefined,
        // 是否显示弹出层
        open: false,
        // 部门名称
        deptName: undefined,
        // 默认密码
        initPassword: undefined,
        // 日期范围
        dateRange: [],
        // 状态数据字典
        statusOptions: [],
        // 性别状态字典
        sexOptions: [],
        // 岗位选项
        postOptions: [],
        // 角色选项
        roleOptions: [],
        // 表单参数
        form: {},
        defaultProps: {
          children: "children",
          label: "label"
        },
        // 用户导入参数
        upload: {
          // 是否显示弹出层（用户导入）
          open: false,
          // 弹出层标题（用户导入）
          title: "",
          // 是否禁用上传
          isUploading: false,
          // 是否更新已经存在的用户数据
          updateSupport: 0,
          // 设置上传的请求头部
          headers: {Authorization: "Bearer " + getToken()},
          // 上传的地址
          url: process.env.VUE_APP_BASE_API + "/system/user/importData"
        },
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          userName: undefined,
          phonenumber: undefined,
          status: undefined,
          deptId: undefined
        },
        // 表单校验
        rules: {
          userName: [
            {required: true, message: "用户名称不能为空", trigger: "blur"}
          ],
          nickName: [
            {required: true, message: "用户昵称不能为空", trigger: "blur"}
          ],
          deptId: [
            {required: true, message: "归属部门不能为空", trigger: "blur"}
          ],
          password: [
            {required: true, message: "用户密码不能为空", trigger: "blur"}
          ],
          email: [
            {required: true, message: "邮箱地址不能为空", trigger: "blur"},
            {
              type: "email",
              message: "'请输入正确的邮箱地址",
              trigger: ["blur", "change"]
            }
          ],
          phonenumber: [
            {required: true, message: "手机号码不能为空", trigger: "blur"},
            {
              pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/,
              message: "请输入正确的手机号码",
              trigger: "blur"
            }
          ]
        },
        selectId: ''
      };
    },
    watch: {
      // 根据名称筛选部门树
      deptName(val) {
        this.$refs.tree.filter(val);
      }
    },
    created() {
      // this.getList();
      this.getTreeselect();
      this.getDicts("sys_normal_disable").then(response => {
        this.statusOptions = response.data;
      });
      this.getDicts("sys_user_sex").then(response => {
        this.sexOptions = response.data;
      });
      this.getConfigKey("sys.user.initPassword").then(response => {
        this.initPassword = response.msg;
      });
    },
    methods: {
      handleOk() {

      },
      dbClick(row, column) {
        this.$set(this.projectObj, 'houseBaseId', row.houseBaseId)
        this.open = true;
        console.log(row, column);
      },
      closeModal() {
          this.$confirm('此操作将不会保存修改的数据, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.open = false;
            const {projectName, projectId, entrustName} = this.projectObj
            this.projectObj = {id: projectId, projectName, projectId, entrustName};
            this.getList();
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消操作'
            });
          });

      },
      changeStatus(status, isDeleteTip) {
        console.log('log');
        if (isDeleteTip) {
          this.$confirm('此操作将不会保存修改的数据, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.open = status;
            const {projectName, projectId, entrustName} = this.projectObj
            this.projectObj = {id: projectId, projectName, projectId, entrustName};
            this.getList();
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除'
            });
          });
        } else {
          this.open = status;
          const {projectName, projectId, entrustName} = this.projectObj
          this.projectObj = {id: projectId, projectName, projectId, entrustName};
          this.getList();
        }



      },
      handleCancel() {
        this.open = false;
      },
      /** 查询列表 */
      getList() {
        getHouseBaseById({projectId: this.projectObj.projectId, ...this.queryParams}).then(res => {
          this.userList = res.rows;
          this.total = res.total;
        })
        // this.loading = true;
        // listUser(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
        //     this.userList = response.rows;
        //     this.total = response.total;
        //     this.loading = false;
        //   }
        // );
      },
      /** 查询部门下拉树结构 */
      getTreeselect() {
        this.loading = true;
        listProject().then(
          response => {
            response.rows.map(item => {
              item.label = item.projectName
              item.id = item.projectId

            });
            // this.projectObj.id = response.rows[0].projectId;
            // this.getList();
            this.$nextTick(() => {
              this.$refs.tree.setCheckedKeys([response.rows[0].projectId]);//获取已经设置的资源后渲染
            });
            // this.$set(this.selectId, response.rows[0].projectId.toString());
            // this.selectId = response.rows[0].projectId;
            this.deptOptions = response.rows;

            console.log(this.deptOptions);
            // this.deptOptions = [
            //   {
            //     id: 100,
            //     label: "中诚评估项目1"
            //   },{
            //     id: 130,
            //     label: "新建土地项目"
            //   },{
            //     id: 102,
            //     label: "中诚评估项目3"
            //   },{
            //     id: 1010,
            //     label: "中诚评估项目4"
            //   },{
            //     id: 1017,
            //     label: "中诚评估项目5"
            //   },{
            //     id: 110,
            //     label: "中诚评估项目6"
            //   },
            // ];

            // this.total = response.total;
            this.loading = false;
          }
        );
      },
      // 筛选节点
      filterNode(value, data) {
        if (!value) return true;
        return data.label.indexOf(value) !== -1;
      },
      // 节点单击事件
      handleNodeClick(data) {
        console.log(data);
        this.projectObj = data;
        // this.queryParams.deptId = data.id;
        // this.queryParams.label = data.label;
        this.getList();

      },
      // 用户状态修改
      handleStatusChange(row) {
        let text = row.status === "0" ? "启用" : "停用";
        this.$confirm('确认要"' + text + '""' + row.userName + '"用户吗?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function () {
          return changeUserStatus(row.userId, row.status);
        }).then(() => {
          this.msgSuccess(text + "成功");
        }).catch(function () {
          row.status = row.status === "0" ? "1" : "0";
        });
      },
      // 取消按钮
      cancel() {
        this.open = false;
        this.reset();
      },
      // 表单重置
      reset() {
        this.form = {
          userId: undefined,
          deptId: undefined,
          userName: undefined,
          nickName: undefined,
          password: undefined,
          phonenumber: undefined,
          email: undefined,
          sex: undefined,
          status: "0",
          remark: undefined,
          postIds: [],
          roleIds: []
        };
        this.resetForm("form");
      },
      /** 搜索按钮操作 */
      handleQuery() {
        this.queryParams.page = 1;
        this.getList();
      },
      /** 重置按钮操作 */
      resetQuery() {
        this.dateRange = [];
        this.resetForm("queryForm");
        this.handleQuery();
      },
      // 多选框选中数据
      handleSelectionChange(selection) {
        console.log(selection);
        this.ids = selection.map(item => {
          return item.houseBaseId
        });
        console.log(this.ids);
        this.single = selection.length != 1;
        this.multiple = !selection.length;
      },
      /** 新增按钮操作 */
      handleAdd() {
        // this.reset();
        // this.getTreeselect();
        // getUser().then(response => {
        //   this.postOptions = response.posts;
        //   this.roleOptions = response.roles;
        this.$set(this.projectObj, 'hytouseBaseId', null)
        console.log('2222', this.projectObj.houseBaseId);
        this.open = true;
        //   this.title = "新建项目";
        //   this.form.password = this.initPassword;
        // });
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.$set(this.projectObj, 'houseBaseId', row.houseBaseId)
        this.open = true;
        // this.reset();
        // this.getTreeselect();
        // const userId = row.userId || this.ids;
        // getUser(userId).then(response => {
        //   this.form = response.data;
        //   this.postOptions = response.posts;
        //   this.roleOptions = response.roles;
        //   this.form.postIds = response.postIds;
        //   this.form.roleIds = response.roleIds;
        //   this.open = true;
        //   this.title = "修改项目";
        //   this.form.password = "";
        // });
      },
      /** 重置密码按钮操作 */
      handleResetPwd(row) {
        this.$prompt('请输入"' + row.userName + '"的新密码', "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消"
        }).then(({value}) => {
          resetUserPwd(row.userId, value).then(response => {
            if (response.code === 200) {
              this.msgSuccess("修改成功，新密码是：" + value);
            } else {
              this.msgError(response.msg);
            }
          });
        }).catch(() => {
        });
      },
      /** 提交按钮 */
      submitForm: function () {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.userId != undefined) {
              updateUser(this.form).then(response => {
                if (response.code === 200) {
                  this.msgSuccess("修改成功");
                  this.open = false;
                  this.getList();
                } else {
                  this.msgError(response.msg);
                }
              });
            } else {
              addUser(this.form).then(response => {
                if (response.code === 200) {
                  this.msgSuccess("新增成功");
                  this.open = false;
                  this.getList();
                } else {
                  this.msgError(response.msg);
                }
              });
            }
          }
        });
      },
      /** 删除按钮操作 */
      handleDelete(row = null) {
        console.log(this.ids);

        this.$confirm('是否确认删除该房产信息？', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(async () => {
          if (row) this.ids = [row.houseBaseId];
          console.log(111, row);
          for (let item of this.ids) {
            await houseBaseDelete(item).then(() => {
            });
          }
          await this.getList();
          await this.msgSuccess("删除成功");
        })
      },
      /** 导出按钮操作 */
      handleExport() {
        const queryParams = this.queryParams;
        this.$confirm('是否确认导出所有用户数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function () {
          return exportUser(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function () {
        });
      },
      /** 导入按钮操作 */
      handleImport() {
        this.upload.title = "用户导入";
        this.upload.open = true;
      },
      /** 下载模板操作 */
      importTemplate() {
        importTemplate().then(response => {
          this.download(response.msg);
        });
      },
      // 文件上传中处理
      handleFileUploadProgress(event, file, fileList) {
        this.upload.isUploading = true;
      },
      // 文件上传成功处理
      handleFileSuccess(response, file, fileList) {
        this.upload.open = false;
        this.upload.isUploading = false;
        this.$refs.upload.clearFiles();
        this.$alert(response.msg, "导入结果", {dangerouslyUseHTMLString: true});
        this.getList();
      },
      // 提交上传文件
      submitFileForm() {
        this.$refs.upload.submit();
      }
    }
  };
</script>
<style scoped lang="less">
  .el-table {
    & ::v-deep .trClass {
      cursor: pointer;
    }
  }

</style>
