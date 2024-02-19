<script setup>
import 'bootstrap/dist/css/bootstrap.min.css'
import '../assets/css/main.css'
defineProps({
  msg: {
    type: String,
    required: true
  }
})
</script>

<template>
  <div class="vue-tempalte">
    <form v-on:submit.prevent="login">
      <h3>Sign Up</h3>
      <div class="mb-3">
        <label>Full Name</label>
        <input type="text" class="form-control form-control-lg" v-model="user.name" />
      </div>
      <div class="mb-3">
        <label>Email address</label>
        <input type="email" class="form-control form-control-lg" v-model="user.emailId" />
      </div>
      <div class="mb-3">
        <label>Password</label>
        <input type="password" class="form-control form-control-lg" v-model="user.password" />
      </div>
      <div class="mb-3">
        <label for="language" id="role-label">Role</label>
        <select name="role" class="form-control form-control-lg" id="role" v-model="user.role">
          <div class="mb-3">dkjds</div>
          <option value="student">Student</option>
          <option value="python">Teacher</option>
        </select>
      </div>
      <button type="submit" class="btn btn-dark btn-lg btn-block">Sign Up</button>
      <p class="forgot-password text-right">
        Already registered
        <router-link :to="{ name: 'login' }">sign in?</router-link>
      </p>
    </form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      user: {
        name: '',
        emailId: '',
        password: '',
        role: ''
      }
    }
  }
}
</script>
