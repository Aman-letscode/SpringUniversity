<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <!-- Navigation -->
  <nav
    class="navbar shadow bg-white rounded justify-content-between flex-nowrap flex-row fixed-top"
  >
    <div class="container">
      <a class="navbar-brand float-left" href="#"> University.io </a>
      <ul class="nav navbar-nav flex-row float-right">
        <li class="nav-item">
          <router-link class="btn btn-outline-primary" to="/login">Sign in</router-link>
        </li>
        <li class="nav-item">
          <router-link class="btn btn-outline-primary" to="/signup">Sign up</router-link>
        </li>
      </ul>
    </div>
  </nav>
  <!-- <main> -->
    <router-view />
  <!-- </main> -->
</template>

<style scoped>
.nav-item {
  margin-right: 1rem;
}
</style>
