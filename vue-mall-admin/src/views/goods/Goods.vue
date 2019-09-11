<template>
  <div class="block">
    <span class="demonstration"></span>
    <el-cascader
      v-model="value"
      :options="options"
      :props="{ expandTrigger: 'hover' }"
      @change="handleChange"
    ></el-cascader>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        value: [],
        options: [{
          value: 'zhinan',
          label: '指南',
          children: [{
            value: 'shejiyuanze',
            label: '设计原则',
            children: [{
              value: 'yizhi',
              label: '一致'
            }, {
              value: 'fankui',
              label: '反馈'
            }, {
              value: 'xiaolv',
              label: '效率'
            }, {
              value: 'kekong',
              label: '可控'
            }]
          }
        ]
        }]
    };
    },
    
    methods: {
      handleChange(value) {
        console.log(value);
      }
    }
  }
</script>
<style lang='scss' scoped>
</style>