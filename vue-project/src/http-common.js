import axios from 'axios'

axios.defaults.withCredentials = true

axios.interceptors.request.use((config) => {
  config.headers['crossorigin'] = 'true'
  return config
})

export default axios.create({
  baseURL: 'http://localhost:8080',
  headers: {
    'Content-Type': 'application/json'
  }
})
