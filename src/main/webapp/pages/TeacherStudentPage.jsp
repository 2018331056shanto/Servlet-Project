<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script src="https://cdn.tailwindcss.com"></script>

</head>
<body>

<nav
  class="relative flex w-full flex-nowrap items-center justify-between bg-neutral-100 py-4 text-neutral-500 shadow-lg hover:text-neutral-700 focus:text-neutral-700 lg:flex-wrap lg:justify-start"
  data-te-navbar-ref>
  <div class="flex w-full flex-wrap items-center justify-between px-6">
    <!-- Hamburger button for mobile view -->
    <button
      class="block border-0 bg-transparent px-2.5 py-2 text-neutral-500 hover:no-underline hover:shadow-none focus:no-underline focus:shadow-none focus:outline-none focus:ring-0 lg:hidden"
      type="button"
      data-te-collapse-init
      data-te-target="#navbarSupportedContent3"
      aria-controls="navbarSupportedContent3"
      aria-expanded="false"
      aria-label="Toggle navigation">
      <!-- Hamburger icon -->
      <span class="[&>svg]:w-7">
        <svg
          xmlns="http://www.w3.org/2000/svg"
          viewBox="0 0 24 24"
          fill="currentColor"
          class="h-7 w-7">
          <path
            fill-rule="evenodd"
            d="M3 6.75A.75.75 0 013.75 6h16.5a.75.75 0 010 1.5H3.75A.75.75 0 013 6.75zM3 12a.75.75 0 01.75-.75h16.5a.75.75 0 010 1.5H3.75A.75.75 0 013 12zm0 5.25a.75.75 0 01.75-.75h16.5a.75.75 0 010 1.5H3.75a.75.75 0 01-.75-.75z"
            clip-rule="evenodd" />
        </svg>
      </span>
    </button>

    <!-- Collapsible navbar container -->
    <div
      class="!visible hidden flex-grow basis-[100%] items-center lg:!flex lg:basis-auto"
      id="navbarSupportedContent3"
      data-te-collapse-item>
      <!-- Navbar title -->
      <a class="text-xl text-black" href="/Servlet-Project/in/admin">Course-Management</a>
      <!-- Left links -->
      <ul
        class="list-style-none mr-auto flex flex-col pl-0 lg:flex-row"
        data-te-navbar-nav-ref>
        <!-- Home link -->
        <li class="lg:px-2" data-te-nav-item-ref>
          <a
            class="active disabled:text-black/30 lg:px-2 [&.active]:text-black/90 dark:[&.active]:text-neutral-400"
            aria-current="page"
            href="/Servlet-Project/in/teacher"
            data-te-nav-link-ref
            >Home</a
          >
        </li>
        
      </ul>
       <ul class="list-style-none ml-auto flex flex-col pl-0 lg:flex-row" data-te-navbar-nav-ref>
        <!-- Logout link -->
        <li class="lg:px-2" data-te-nav-item-ref>
          <form method="post" action="/Servlet-Project/logout">
            <button class="active disabled:text-black/30 lg:px-2 [&.active]:text-black/90 dark:[&.active]:text-neutral-400" type="submit">Logout</button>
          </form>
        </li>
      </ul>
    </div>
  </div>
</nav>
<div class="w-full flex justify-center mt-10 tracking-widest font-mono font-semibold text-2xl">

 <div class="w-full flex flex-col justify-center items-center mt-4">
 <span class="font-serif font-bold text-2xl ">List Of Students in <span>${courseName }</span></span>
 <div class="h-1 w-[250px] bg-black"></div>
</div>
</div>

<div class="metric-card bg-white text-2xl dark:bg-gray-900 border border-gray-200 dark:border-gray-800 rounded-lg p-4 max-w-72 w-full" style="cursor: auto;">
      Total Students
      <p class="mt-2 text-2xl font-bold spacing-sm text-black dark:text-white" style="cursor: auto;"> ${noOfStudents } </p>
    </div>

<div class="relative flex mt-10 overflow-x-auto justify-center shadow-md sm:rounded-lg">
    <table class="w-4/5 text-sm  text-left text-gray-500 dark:text-gray-400">
        <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr>
                <th scope="col" class="px-6 text-lg py-3">
                    Student Name
                </th>
                <th scope="col" class="px-6 text-lg py-3">
                    Department
                </th>
                <th scope="col" class="px-6 text-lg py-3">
                    Registration
                </th>
            </tr>
        </thead>
        <tbody>
           <c:forEach var="item" items="${students }">
           
            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">
                <th scope="row" class="px-6 py-4 font-medium text-gray-600 text-base whitespace-nowrap dark:text-white">
					${item.getName()}
                </th>
                <td class="px-6 py-4 font-medium text-gray-600 text-base whitespace-nowrap dark:text-white">
					${item.getDepartment().getName() }
                </td>
                <td class="px-6 py-4 font-medium text-gray-600 text-base whitespace-nowrap dark:text-white">
                    ${ item.getId() } 
                </td>
               
            </tr>
 </c:forEach> 
            
           
        </tbody>
    </table>
</div>

</body>
</html>