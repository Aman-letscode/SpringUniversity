<script setup>
import '../assets/css/main.css'
defineProps({
  msg: {
    type: String,
    required: true
  }
})
</script>

<template>
  <div class="card-list">
    <div class="card" style="width: 18rem" v-for="(course, index) in courses">
      <div class="card-body">
        <h5 class="card-title">{{ course.courseCode }} : {{ course.courseName }}</h5>
        <p class="card-text">
          {{ course.description }}
        </p>
        <a href="#" class="btn btn-primary">Go somewhere</a>
      </div>
    </div>
  </div>
</template>

<script>
import CourseService from '@/services/CourseService'
export default {
  name: 'Courses',
  data() {
    return {
      courses: []
    }
  },
  methods: {
    getCourses() {
      CourseService.getAll()
        .then((response) => {
          this.courses = response.data.data
        })
        .catch((e) => {
          alert(e)
        })
    }
  },
  created() {
    this.getCourses()
  }
}
</script>
