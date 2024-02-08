
<script setup>
import 'bootstrap/dist/css/bootstrap.min.css'
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
            <h3>Sign Up</h3>
            <div class="mb-3">
                <label>Full Name</label>
                <input type="text" class="form-control form-control-lg"/>
            </div>
            <div class="mb-3">
                <label>Email address</label>
                <input type="email" class="form-control form-control-lg" />
            </div>
            <div class="mb-3">
                <label>Password</label>
                <input type="password" class="form-control form-control-lg" />
            </div>
            <!-- <div class="mb-3">
                <label>Role</label>
                <select name="cars" class="form-control form-control-lg" id="cars" form="carform">
                    <option value="student">Student</option>
                    <option value="tutor">Tutor</option>
                  </select>
            </div> -->
            <div class="mb-3">

                <!-- <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" data-coreui-toggle="dropdown" aria-expanded="false">
                      Dropdown button
                    </button>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="#">Action</a></li>
                      <li><a class="dropdown-item" href="#">Another action</a></li>
                      <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                  </div> -->
                  <label for="language" id="role-label">Role</label>
                  <select name="role" class="form-control form-control-lg" id="role">
                    <div class="mb-3">dkjds</div>
                    <option value="student">Student</option>
                    <option value="python">Teacher</option>
                  </select>
            </div>
            <button type="submit" class="btn btn-dark btn-lg btn-block">Sign Up</button>
            <p class="forgot-password text-right">
                Already registered 
                <router-link :to="{name: 'login'}">sign in?</router-link>
            </p>
        </form>
    </div>
</template>
<script>
    export default {
        data() {
            return {}
        }
    }
</script>