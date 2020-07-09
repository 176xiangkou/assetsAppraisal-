<template>
    <div class="form-input-wraper">
        <div v-if="wholeType === 'span'">
            <span v-if="inputType === 'input' || inputType === 'textArea' || inputType === 'inputNumber'">{{value}}</span>
            <span v-else-if="inputType === 'select' || inputType === 'radio'">{{getSelectName()}}</span>
            <span v-else-if="inputType === 'treeSelect'">{{getTreeSelectName()}}</span>
            <span v-else-if="inputType === 'rangePicker'">{{getRangePicker()}}</span>
            <span v-else>{{value}}</span>
        </div>
        <div v-else>
            <template v-if="inputType === 'span'">
                <span>{{value}}</span>
            </template>
            <template v-else-if="inputType === 'input'">
                <div :class="{'has-error' : (value && validateForm.type && !regExpConfig[validateForm.type].test(value))}">
                    <a-input :value="value"
                             v-bind="{allowClear, placeholder, ...$attrs }"
                             :style="{width: contentWidth}"
                             @change="(val) => $emit('change', val.target.value)"
                             @input="$emit('input', $event.target.value)"></a-input>
                </div>
            </template>
            <template v-else-if="inputType === 'datePicker'">
                <a-date-picker v-bind="{placeholder, allowClear, ...$attrs }"
                               :showToday="false"
                               :show-time="dateFormat !=='YYYY-MM-DD' ? true : false"
                               :format="dateFormat"
                               :style="{width: contentWidth}"
                               @change="(val) => {$emit('input', val ? moment(val._d).format(dateFormat) : '')}"
                               :value="value ? moment(value, dateFormat) : null"></a-date-picker>
            </template>
            <template v-else-if="inputType === 'select'">
                <a-select dropdownMatchSelectWidth
                          showSearch
                          :defaultValue="value"
                          :filterOption="filterOption"
                          :value="value"
                          :style="{width: contentWidth}"
                          @change="(val, option) => {$emit('input', val);$emit('change', {val, option})}"
                          v-bind="{allowClear,placeholder, ...$attrs}"
                >
                    <a-select-option v-for="(item,index) in selectList"
                                     :key="index"
                                     :value="item[valueName]">{{item[labelName]}}
                    </a-select-option>
                </a-select>
            </template>
            <template v-else-if="inputType === 'rangePicker'">
                <a-range-picker :format="dateFormat"
                                @change="ranger"
                                :value="rangePicker()"
                                :showTime="showTime"></a-range-picker>
            </template>

            <template v-else-if="inputType === 'textArea'">
                <a-textarea v-bind="{placeholder, rows, ...$attrs }"
                            :value="value"
                            :style="{maxWidth: contentWidth}"
                            @input="$emit('input',$event.target.value)">
                </a-textarea>
            </template>
            <template v-else-if="inputType === 'radio'">
                <a-radio-group name="radioGroup"
                               :value="value"
                               :style="{width: contentWidth}"
                               @input="(val) => $emit('input',val)">
                    <a-radio :value="item[valueName]"
                             v-for="(item, index) in selectList"
                             :key="index">
                        {{item[labelName]}}
                    </a-radio>
                </a-radio-group>
            </template>
            <template v-else-if="inputType === 'inputNumber'">
                <a-input-number id="inputNumber"
                                v-bind="{placeholder, ...$attrs}"
                                :style="{width: contentWidth}"
                                :value="value"
                                :min="0"
                                @change="(val) => {$emit('input',val)}"
                />
            </template>
            <!--<template v-else-if="inputType === 'upload'">-->
                <!--<BaseUpload :url="uploadMaterial"-->
                            <!--v-if="uploadMaterial"-->
                            <!--:name="'file'"-->
                            <!--:value="value"-->
                            <!--:style="{marginRight: '10px', width: contentWidth}"-->
                            <!--class="isHaveMes"-->
                            <!--@on-upload-finished="(val) => finished(val)">-->
                    <!--<a-button type="primary">上传附件</a-button>-->
                <!--</BaseUpload>-->
                <!--<div v-else>-->
                        <!--<a-button type="primary">上传附件</a-button>-->
                    <!--<input style="opacity: 0;height: 32px;position: relative;top: -32px;" type="file" @change="uploadMutiply">-->
                    <!--<p style="margin-top: -15px;">{{value && value.name}}</p>-->

                <!--</div>-->
            <!--</template>-->
            <template v-else-if="inputType === 'treeSelect'">
                <a-tree-select :showCheckedStrategy="SHOW_PARENT"
                               :treeData="selectList"
                               :value="value"
                               v-bind="{placeholder, ...$attrs}"
                               @change="getTree"
                               treeCheckable/>
            </template>
        </div>
    </div>
</template>

<script>
    import {TreeSelect} from 'ant-design-vue'

    const SHOW_PARENT = TreeSelect.SHOW_PARENT
    // import BaseUpload from '@/components/BaseUpload/BaseUpload'
    // import {regExpConfig} from '@/utils/regExpConfig'
    // import { downloadFile } from '@/utils/helper'
    import moment from 'moment'

    export default {
        name: 'formInput',
        // components: {BaseUpload},
        props: {
            'value': {
                type: [String, Number, Object, Array, File],
            },
            'allowClear': {type: Boolean, default: true},
            'placeholder': {
                type: String,
                default: '请输入',
            },
            'inputType': {
                type: String,
                default: 'input',
            },
            'rows': {
                type: Number,
                default: 4,
            },
            'uploadMaterial': String,
            'dateFormat': {
                type: String,
                default: 'YYYY-MM-DD'
            },
            // select
            'labelName': {type: String, default: 'text'},
            'valueName': {type: String, default: 'value'},
            'contentWidth': {type: String, default: '100%'},
            'selectList': Array,
            'wholeType': String,
            'validateForm': {
                type: Object,
                default: () => {
                    return {
                        isRequire: false,
                        type: ''
                    }
                }
            },
            showTime: {
                type: Object,
                default: () => {
                    return {format: "HH:mm:ss"};
                }
            },
        },
        data() {
            return {
                uploadObj: {name: '', url: ''},
                SHOW_PARENT,
                regExpConfig,
                isError: false
            }
        },
        created() {
        },
        methods: {
            uploadMutiply(e) {
                console.log(e.target.files);
                this.$emit('input', e.target.files[0])
            },
            getRangePicker() {
                const [s,e] = this.value;
                if (!s) return '暂无信息'
                return `${s}-${e}`
            },
            filterOption(input, option) {
                return (
                    option.componentOptions.children[0].text.toLowerCase().indexOf(input.toLowerCase()) >= 0
                );
            },
            rangePicker () {
                if (this.value && this.value.length)
                    return [
                        this.value[0] ? moment(this.value[0], this.dateFormat) : "",
                        this.value[1] ? moment(this.value[1], this.dateFormat) : ""
                    ];
            },
            ranger(date, dateStr) {
                this.$emit('input', dateStr);
            },

            getSelectName() {
                const list = this.selectList.find(item => {
                    return item[this.valueName] == this.value
                });
                if (list) {
                    return list[this.labelName]
                }
                return '暂未选择';
            },
            getTreeSelectName() {
                if (this.value && this.value.length) {
                    let data = []
                    this.value.map(item => {
                        const reduce = (datas) => {
                            datas.map((sitem) => {
                                try {
                                    if (sitem.value == item) {
                                        data.push(sitem.title)
                                        throw ('查找完毕');
                                    } else if (sitem.children)
                                        return reduce(sitem.children)
                                } catch (e) {
                                    console.log(e)
                                }
                            })
                        }
                        reduce(this.selectList)
                    })
                    return data.join(',');
                }
                return '暂未选择';
            },
            getTree(val) {
                this.$emit('input', val);
            },
            moment,
            // download (url) {
            //   downloadFile(url)
            // },
            splitStr(value, index) {
                return value.split(',')[index]
            },
            finished(val) {
                this.$emit('input', val.data.filename + ',' + val.data.filepath)
                // this.uploadObj = val
            },
        },
    }
</script>

<style lang="scss" scoped>
    .ant-select {
    }

    .form-input-wraper {
        width: 100%;

        .ant-calendar-picker, .ant-select {
            width: 100%;
            min-width: 100px;
        }

        // display: inline-block;
    }

    //   /*height: 42px;*/
    //   display: flex;
    //   align-items: center;
    //   /*padding: 0 65px 0 36px;*/
    //   /*textarea {*/
    //   /*  margin-left: 23px !important;*/
    //   /*}*/
    //   /*.label {*/
    //   /*  padding-left: 35px !important;*/
    //   /*}*/
    //   span:nth-of-type(1) {
    //     padding-left: 35px;
    //     font-size: 16px;
    //     font-family: PingFangSC-Medium, PingFang SC;
    //     font-weight: 500;
    //     color: rgba(0, 0, 0, 0.65);
    //     line-height: 23px;
    //   }
    //   input:nth-last-child(1) {
    //     max-width: 438px;
    //   }
    //   .ant-input {
    //     // width: 82%;
    //     // max-width: 438px;
    //   }
    //   span:nth-of-type(2) {
    //     font-size: 16px;
    //     font-family: PingFangSC-Regular, PingFang SC;
    //     font-weight: 400;
    //     color: rgba(51, 51, 51, 1);
    //     line-height: 23px;
    //   }
    /*input {*/
    /*  flex-grow: 1;*/
    /*  // width: 100%;*/
    /*  // max-width: 360px;*/
    /*  !*height: 42px;*!*/
    /*  max-width:438px;*/
    /*  border-radius: 2px;*/
    /*  border: 1px solid rgba(212, 219, 229, 1);*/
    /*  outline: none;*/
    /*  text-indent: 10px;*/
    /*  &::-webkit-input-placeholder {*/
    /*    color: #cccccc;*/
    /*  }*/
    /*  &.readonly {*/
    /*    border: none;*/
    /*  }*/
    /*}*/
    // }
</style>
