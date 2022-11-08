import React from "react";
import ReactDOM from "react-dom";
import App from "./App.jsx";
import Employee from "./MyComponentTwo.jsx";
import Form from "./MyForm.jsx";
import UserList from "./Fetch.jsx";
import UserCRUD from "./axiosapi/components/UserCRUD.jsx";
import { Router, Route, browserHistory, IndexRoute } from "react-router";
import Home from './axiosapi/components/home.jsx';
import About from './axiosapi/components/about.jsx';
import Contact from './axiosapi/components/contact.jsx';
import EmployeeCRUD from "./EmployeeCRUD.jsx";
import AppRouter from "./AppRoute.jsx";


ReactDOM.render((
    <Router history = {browserHistory}>
    <Route path = "/" component = {AppRouter}>
           <IndexRoute component = {Home} />
           <Route path = "home" component = {Home} />      
           <Route path = "about" component = {About} />
           <Route path = "contact" component = {Contact} />
           <Route path = "users" component = {UserCRUD} />
           <Route path = "employees" component = {EmployeeCRUD} />
    </Route>
   </Router>
   ), document.getElementById('router'));

// let emp = {name:'Nikhil' , city: 'New York'};

// ReactDOM.render(<App name = "LTI session" age = "35"/> , document.getElementById('app'));

// ReactDOM.render(<Employee emp={emp}/> , document.getElementById('ref'));

// ReactDOM.render(<Form/> , document.getElementById('reactForm'));

// ReactDOM.render(<EmployeeCRUD/> , document.getElementById('employeeForm'));

//ReactDOM.render(<UserCRUD/> , document.getElementById('listUsers'));
