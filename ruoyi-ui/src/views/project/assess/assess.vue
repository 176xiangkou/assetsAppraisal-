<template>
  <div class="houseIndex">
    <a-tabs default-active-key="基本信息" @change="callback">
      <a-tab-pane :key="item.label" :tab="item.label" v-for="item in tabs">
        <component :is="item.key"/>
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
      // components: {baseInfo, updateHouse, twiceApply, trimPrice},
      data() {
          return {
            tabs: [{
              label: '基本信息',
              key: resolve =>
                require.ensure([], () =>
                  resolve(
                    require('./baseInfo')
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
              label: '房屋装修附属价格',
              key: resolve =>
                require.ensure([], () =>
                  resolve(
                    require('./twiceApply')
                  )
                )
            },{
              label: '二次拆装费用',
              key: resolve =>
                require.ensure([], () =>
                  resolve(
                    require('./trimPrice')
                  )
                )
            },]
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
