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
    <form>
      <h3>Forgot Password</h3>
      <div class="mb-3">
        <label>Email address</label>
        <input type="email" class="form-control form-control-lg" />
      </div>
      <button type="submit" class="btn btn-dark btn-lg btn-block">Reset password</button>
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
