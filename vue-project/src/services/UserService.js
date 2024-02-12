import http from '@/http-common'

class UserService {
  getAll() {
    return http.get('/users')
  }

  create(data) {
    return http.post('/signup', data)
  }

  find(id) {
    return http.get(`/user/${id}`)
  }

  update(id, data) {
    return http.put(`/user/${id}`, data)
  }

  delete(id) {
    return http.delete(`/user/${id}`)
  }
  login(data) {
    return http.post('/login', data)
  }
}

export default new UserService()
