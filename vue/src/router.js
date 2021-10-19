import Vue from "vue";
import VueRouter from "vue-router";
const Login = () => import('./views/Login')
const Container = () => import('./views/Container')
const StudentExam = () => import('./views/student/StudentExam')
const StudentTimeTable = () => import('./views/student/StudentTimeTable')
const StudentInfo = () => import('./views/student/StudentInfo')
const StudentCourse= () => import('./views/student/StudentCourse')
const StudentCourseSelect = () => import('./views/student/StudentCourseSelect')
const StudentScore = () => import('./views/student/StudentScore')
const TeacherCourse = () => import('./views/teacher/TeacherCourse')
const TeacherTimetable = () => import('./views/teacher/TeacherTimetable')
const TeacherTimetable = () => import('./views/teacher/TeacherTimetable')
const TeacherGrade = () => import('./views/teacher/TeacherGrade')
const AdminDepartment= () => import('./views/admin/AdminDepartment')
const AdminMajor = () => import('./views/admin/AdminMajor')
const AdminClass = () => import('./views/admin/AdminClass')
const AdminStudent= () => import('./views/admin/AdminStudent')
const AdminTeacher = () => import('./views/admin/AdminTeacher')
const AdminCourse = () => import("./views/admin/AdminCourse")
const AdminStudent = () => import('./views/admin/AdminStudent')
const AdminTeacher = () => import('./views/admin/AdminTeacher')
const AdminCourse = () => import('./views/admin/AdminCourse')
const AdminStudentCourse = () => import('./views/admin/AdminStudentCourse')
const AdminAdmin = () => import('./views/admin/AdminAdmin')
const Home= () => import('./views/Home')
Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "container",
    component: Container,
    children: [
      {
        path: "/student",
        name: "student-home",
        component: Home
      },
      {
        path: "/student/course/select",
        name: "student-course-select",
        component: StudentCourseSelect
      },
      {
        path: "/student/course",
        name: "student-course",
        component: StudentCourse
      },
      {
        path: "/student/timetable",
        name: "student-timetable",
        component: StudentTimeTable
      },
      {
        path: "/student/exam",
        name: "student-exam",
        component: StudentExam
      },
      {
        path: "/student/score",
        name: "student-score",
        component: StudentScore
      },
      {
        path: "/student/info",
        name: "student-info",
        component: StudentInfo
      },
      {
        path: "/teacher",
        name: "teacher-home",
        component: Home
      },
      {
        path: "/teacher/course",
        name: "teacher-course",
        component: TeacherCourse
      },
      {
        path: "/teacher/timetable",
        name: "teacher-timetable",
        component: TeacherTimetable
      },
      {
        path: "/teacher/grade",
        name: "teacher-grade",
        component: TeacherGrade
      },
      {
        path: "/admin",
        name: "admin-home",
        component: Home
      },
      {
        path: "/admin/department",
        name: "admin-department",
        component: AdminDepartment
      },
      {
        path: "/admin/major",
        name: "admin-major",
        component: AdminMajor
      },
      {
        path: "/admin/class",
        name: "admin-class",
        component: AdminClass
      },
      {
        path: "/admin/student",
        name: "admin-student",
        component: AdminStudent
      },
      {
        path: "/admin/teacher",
        name: "admin-teacher",
        component: AdminTeacher
      },
      {
        path: "/admin/course",
        name: "admin-course",
        component: AdminCourse
      },
      {
        path: "/admin/student/course",
        name: "admin-student-course",
        component: AdminStudentCourse
      },
      {
        path: "/admin/admin",
        name: "admin-admin",
        component: AdminAdmin
      }
    ]
  },
  {
    path: "/login",
    name: "login",
    component: Login
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
