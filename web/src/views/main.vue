<template>
  <a-layout id="components-layout-demo-top-side-2">
    <the-header></the-header>
    <a-layout>
      <the-sider></the-sider>
      <a-layout-content
          :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
      >
<!--        所有会员总数：{{count}}-->
        <router-view></router-view>
      </a-layout-content>
    </a-layout>
  </a-layout>
</template>
<script>
import TheHeader from "@/components/the-header";
import TheSider from "@/components/the-sider";
import {defineComponent} from "vue";
// import axios from "axios";
// import {notification} from "ant-design-vue";

export default defineComponent({
  components:{
    TheHeader,
    TheSider
  },
  setup() {
    // const count = ref(0);

    // axios.get("/member/member/count",).then(response => {
    //   let data = response.data;
    //   if (data.success) {
    //     count.value = data.content;
    //   } else {
    //     notification.error({description: data.message});
    //   }
    // })
  return {
    // count
    };
  }
  });
</script>
<style scoped>

</style>