<script setup>
import UserService from '@/services/UserService';
import '../assets/css/main.css';
defineProps({
  msg: {
    type: String,
    required: true
  }
})
</script>


<template>
    <div class="vue-tempalte">
        <form>
            <h3>Sign In</h3>
            <div class="mb-1">
                <label>Email address</label>
                <input type="email" class="form-control form-control-lg" />
            </div>
            <div class="mb-3">
                <label>Password</label>
                <input type="password" class="form-control form-control-lg" />
            </div>
            
            <button type="submit" class="btn btn-dark btn-lg btn-block" @click="login">Login</button>
            <p class="forgot-password text-right mt-2 mb-4">
                <router-link to="/forgot-password">Forgot password ?</router-link>
            </p>
            
        </form>
    </div>
</template>

<script>
import UserService from '@/services/UserService';

export default {
    name: 'login-user',
    data() {
        return {
            user: {
                id: null,
                email: "",
                password: ""
            },
            submitted: false
        }
    },
    methods: {
        login() {
            var data = {
                email: this.user.email,
                password: this.user.password
            }
            UserService.find(data)
                .then(response => {
                    this.user.id = response.data.id
                    this.submitted = true;
                })
                .catch( e => {
                    alert(e)
                })
        },
        newCustomer() {
            this.submitted = false
            this.customer = {}
        }
    }
}
</script>