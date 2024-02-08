import http from "@/http-common";

class CourseService{
    getAll(){
        return http.get('/courses');
    }

    create(data){
        return http.post('/course/addCourse',data);
    }

    find(id){
        return http.get(`/courses/${id}`);
    }

    update(id,data){
        return http.put(`/courses/${id}`,data);
    }

    delete(id){
        return http.delete(`/courses/${id}`);
    }
}


export default new CourseService();