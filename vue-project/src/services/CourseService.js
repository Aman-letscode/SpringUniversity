import http from '@/http-common'

class CourseService {
  getAll() {
    return http.get('/course/list')
  }

  create(data) {
    return http.post('/course/add', data)
  }

  find(id) {
    return http.get(`/course/details/${id}`)
  }

  update(id, data) {
    return http.put(`/course/details/${id}`, data)
  }

  delete(id) {
    return http.delete(`/course/details/${id}`)
  }
}

export default new CourseService()
