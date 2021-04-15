<template>
  <div class="houseIndex">
    <a-tabs default-active-key="基本信息" @change="callback" v-model="currentKeys">
      <a-tab-pane :key="item.label" :tab="item.label" v-for="(item, index) in tabs" :disabled="index > 0 && !projectObj.houseBaseId">
        <component :is="item.key" :projectObj="projectObj" @changeStatus="(status) => $emit('changeStatus', status)"/>
      </a-tab-pane>
    </a-tabs>
    <!--<a-button type="primary">-->
      <!--Primary-->
    <!--</a-button>-->
    <!--2222222-->
    <!--<router-view />-->
  </div>
</template>

<script>
  // import baseInfo from './baseInfo'
  // import updateHouse from './updateHouse'
  // import twiceApply from './twiceApply'
  // import trimPrice from './trimPrice'
    export default {
      name: "index",
      props: ['projectObj'],
      // watch: {
      //   projectObj: {
      //     deep: true,
      //     handler(val) {
      //       this.
      //     }
      //   }
      // },
      // components: {baseInfo, updateHouse, twiceApply, trimPrice},
      watch: {
        projectObj: {
          deep: true,
          handler() {
            this.currentKeys = '基本信息'
          }
        }
      },
      data() {
          return {
            currentKeys: '基本信息',
            tabs: [{
              label: '基本信息',
              key: resolve =>
                require.ensure([], () =>
                  resolve(
                    require('./baseInfo')
                  )
                )
            },{
              label: '房屋信息',
              key: resolve =>
                require.ensure([], () =>
                  resolve(
                    require('./houseTab')
                  )
                )
            },{
              label: '未确权房屋/非沿街往改非',
              key: resolve =>
                require.ensure([], () =>
                  resolve(
                    require('./updateHouse')
                  )
                )
            },{
              label: '房屋装修附属价格/二次拆装费用',
              key: resolve =>
                require.ensure([], () =>
                  resolve(
                    require('./twiceApply')
                  )
                )
            },/*{
              label: '二次拆装费用',
              key: resolve =>
                require.ensure([], () =>
                  resolve(
                    require('./trimPrice')
                  )
                )
            },*/]
          }
      },
      methods: {
        callback(key) {
          console.log(key);
        },
      }
    }
</script>

<style scoped lang="scss">
.houseIndex {
  padding: 0 15px 15px 15px;
}
</style>
