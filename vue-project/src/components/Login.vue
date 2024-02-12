<script setup>
import UserService from '@/services/UserService'
import '../assets/css/main.css'
// defineProps({
//   msg: {
//     type: String,
//     required: true
//   }
// })
</script>

<template>
  <div class="vue-tempalte">
    <form v-on:submit.prevent="login">
      <h3>Sign In</h3>
      <div class="mb-1">
        <label>Email address</label>
        <input type="email" name="email" class="form-control form-control-lg" v-model="user.emailId"/>
      </div>
      <div class="mb-3">
        <label>Password</label>
        <input type="password" name="password" class="form-control form-control-lg" v-model="user.password" />
      </div>

      <button type="submit" class="btn btn-dark btn-lg btn-block" >Login</button>
      <p class="forgot-password text-right mt-2 mb-4">
        <router-link to="/forgot-password">Forgot password ?</router-link>
      </p>
    </form>
  </div>
</template>

<script>
import UserService from '@/services/UserService'

export default {
  name: 'login-user',
  data() {
    return {
      user: {
        id: null,
        emailId: '',
        password: '',
        role:''
      },
      submitted: false
    }
  },
  methods: {
    handleSubmit(){
      
    },
    login() {
      this.user.role = 'student'
      console.log(this.user)
      UserService.login(this.user)
        .then((response) => {
          this.user.id = response.data.user.id
          this.user.emailId = response.data.user.emailId
          this.user.password = response.data.user.password
          this.user.role = response.data.user.role
          console.log(this.user)
          // alert(response.data)
          // this.submitted = true
        })
        .catch((e) => {
          alert(e)
        })
        
    }
  }
}
</script>
