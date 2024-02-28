<template>
  <a-layout id="components-layout-demo-top-side-2">
    <the-header></the-header>
    <a-layout>
      <the-sider></the-sider>
      <a-layout-content
          :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
      >
        content
        <router-view></router-view>
      </a-layout-content>
    </a-layout>
  </a-layout>
</template>
<script setup>
import TheHeader from "@/components/the-header";
import TheSider from "@/components/the-sider";
</script>
<style scoped>

</style>