// var d1 = new Date();    // 获取当前系统时间
// d1.getFullYear();        // 获取年信息
// d1.getMonth();            // 获取月信息
// d1.getDate();            // 获取天信息
// d1.getDay();            // 获取星期信息
// // 设置 2021年7月13日
// var d2 = new Date(2021, 7, 13);        // 月是从0开始计数， 需要减一
// d2.getFullYear();                    // 2016
// d2.getMonth();                        // 2
// d2.getDate();                        // 15
// d2.toLocaleDateString();            // "2016/3/15" 证明设置正确
//
// (function(){
//     /*
//      * 用于记录日期，显示的时候，根据dateObj中的日期的年月显示
//      */
//     var dateObj = (function(){
//         var _date = new Date();        // 默认为当前系统时间
//         return {
//             getDate : function(){
//                 return _date;
//             },
//             setDate : function(date) {
//                 _date = date;
//             }
//         };
//     })();
//
//     // 设置calendar div中的html部分
//     renderHtml();
//     // 表格中显示日期
//     showCalendarData();
//     // 绑定事件
//     bindEvent();
//
//     /**
//      * 渲染html结构
//      */
//     function renderHtml() {
//         var calendar = document.getElementById("calendar");
//         var titleBox = document.createElement("div");    // 标题盒子 设置上一月 下一月 标题
//         var bodyBox = document.createElement("div");    // 表格区 显示数据
//
//         // 设置标题盒子中的html
//         titleBox.className = 'calendar-title-box';
//         titleBox.innerHTML = "<span class='prev-month' id='prevMonth'></span>" +
//             "<span class='calendar-title' id='calendarTitle'></span>" +
//             "<span id='nextMonth' class='next-month'></span>";
//         calendar.appendChild(titleBox);        // 添加到calendar div中
//
//         // 设置表格区的html结构
//         bodyBox.className = 'calendar-body-box';
//         var _headHtml = "<tr>" +
//             "<th>日</th>" +
//             "<th>一</th>" +
//             "<th>二</th>" +
//             "<th>三</th>" +
//             "<th>四</th>" +
//             "<th>五</th>" +
//             "<th>六</th>" +
//             "</tr>";
//         var _bodyHtml = "";
//
//         // 一个月最多31天，所以一个月最多占6行表格
//         for(var i = 0; i < 6; i++) {
//             _bodyHtml += "<tr>" +
//                 "<td></td>" +
//                 "<td></td>" +
//                 "<td></td>" +
//                 "<td></td>" +
//                 "<td></td>" +
//                 "<td></td>" +
//                 "<td></td>" +
//                 "</tr>";
//         }
//         bodyBox.innerHTML = "<table id='calendarTable' class='calendar-table'>" +
//             _headHtml + _bodyHtml +
//             "</table>";
//         // 添加到calendar div中
//         calendar.appendChild(bodyBox);
//     }
//
//     /**
//      * 表格中显示数据，并设置类名
//      */
//     function showCalendarData() {
//         var _year = dateObj.getDate().getFullYear();
//         var _month = dateObj.getDate().getMonth() + 1;
//         var _dateStr = getDateStr(dateObj.getDate());
//
//         // 设置顶部标题栏中的 年、月信息
//         var calendarTitle = document.getElementById("calendarTitle");
//         var titleStr = _dateStr.substr(0, 4) + "年" + _dateStr.substr(4,2) + "月";
//         calendarTitle.innerText = titleStr;
//
//         // 设置表格中的日期数据
//         var _table = document.getElementById("calendarTable");
//         var _tds = _table.getElementsByTagName("td");
//         var _firstDay = new Date(_year, _month - 1, 1);    // 当前月第一天
//         for(var i = 0; i < _tds.length; i++) {
//             var _thisDay = new Date(_year, _month - 1, i + 1 - _firstDay.getDay());
//             var _thisDayStr = getDateStr(_thisDay);
//             _tds[i].innerText = _thisDay.getDate();
//             //_tds[i].data = _thisDayStr;
//             _tds[i].setAttribute('data', _thisDayStr);
//             if(_thisDayStr == getDateStr(new Date())) {        // 当前天
//                 _tds[i].className = 'currentDay';
//             }else if(_thisDayStr.substr(0, 6) == getDateStr(_firstDay).substr(0, 6)) {
//                 _tds[i].className = 'currentMonth';    // 当前月
//             }else {        // 其他月
//                 _tds[i].className = 'otherMonth';
//             }
//         }
//     }
//
//     /**
//      * 绑定上个月下个月事件
//      */
//     function bindEvent() {
//         var prevMonth = document.getElementById("prevMonth");
//         var nextMonth = document.getElementById("nextMonth");
//         addEvent(prevMonth, 'click', toPrevMonth);
//         addEvent(nextMonth, 'click', toNextMonth);
//     }
//
//     /**
//      * 绑定事件
//      */
//     function addEvent(dom, eType, func) {
//         if(dom.addEventListener) {    // DOM 2.0
//             dom.addEventListener(eType, function(e){
//                 func(e);
//             });
//         } else if(dom.attachEvent){    // IE5+
//             dom.attachEvent('on' + eType, function(e){
//                 func(e);
//             });
//         } else {    // DOM 0
//             dom['on' + eType] = function(e) {
//                 func(e);
//             }
//         }
//     }
//
//     /**
//      * 点击上个月图标触发
//      */
//     function toPrevMonth() {
//         var date = dateObj.getDate();
//         dateObj.setDate(new Date(date.getFullYear(), date.getMonth() - 1, 1));
//         showCalendarData();
//     }
//
//     /**
//      * 点击下个月图标触发
//      */
//     function toNextMonth() {
//         var date = dateObj.getDate();
//         dateObj.setDate(new Date(date.getFullYear(), date.getMonth() + 1, 1));
//         showCalendarData();
//     }
//
//     /**
//      * 日期转化为字符串， 4位年+2位月+2位日
//      */
//     function getDateStr(date) {
//         var _year = date.getFullYear();
//         var _month = date.getMonth() + 1;        // 月从0开始计数
//         var _d = date.getDate();
//
//         _month = (_month > 9) ? ("" + _month) : ("0" + _month);
//         _d = (_d > 9) ? ("" + _d) : ("0" + _d);
//         return _year + _month + _d;
//     }
// })();
//
// var table = document.getElementById("calendarTable");
// var tds = table.getElementsByTagName('td');
// for(var i = 0; i < tds.length; i++) {
//     addEvent(tds[i], 'click', function(e){
//         console.log(e.target.getAttribute('data'));
//     });
// }
//
//判断当前年份是否是闰年(闰年2月份有29天，平年2月份只有28天)


// function isLeap(year) {
//     return year % 4 === 0 ? (year % 100 !== 0 ? 1 : (year % 400 === 0 ? 1 : 0)) : 0;
// }
// var i, k,
//     //获取今日日期
//     today = new Date(),
//     //获取年份
//     y = today.getFullYear(),
//     //获取月份(注意：月份从0开始计算，获取的值比正常月份少1)
//     m = today.getMonth(),
//     //获取日期中的日(方便在建立日期表格时高亮显示当天)
//     d = today.getDate(),
//     //获取当月的第一天
//     firstday = new Date(y, m, 1),
//     //判断第一天是星期几(返回[0-6]中的一个，0代表星期天，1代表星期一，以此类推)
//     dayOfWeek = firstday.getDay(),
//     //创建月份数组
//     days_per_month = new Array(31, 28 + isLeap(y), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31),
//     //确定日期表格所需的行数
//     str_nums = Math.ceil((dayOfWeek + days_per_month[m]) / 7);
// document.write("<table cellspacing='0'><tr><td colspan ='7'>" + y + "年" + (m + 1) + "月" + "</td></tr>");
// //打印表格第一行(显示星期)
// document.write("<tr><th>日</th><th>一</th><th>二</th><th>三</th><th>四</th><th>五</th><th>六</th></tr>");
// //二维数组创建日期表格
// for(i = 0; i < str_nums; i += 1) {
//     document.write('<tr>');
//     for(k = 0; k < 7; k++) {
//         //为每个表格创建索引,从0开始
//         var idx = 7 * i + k;
//         //将当月的1号与星期进行匹配
//         var date = idx - dayOfWeek + 1;
//         //索引小于等于0或者大于月份最大值就用空表格代替
//         (date <= 0 || date > days_per_month[m]) ? date = ' ': date = idx - dayOfWeek + 1;
//         //高亮显示当天
//         date === d ? document.write('<td class="today">' + date + '</td>') : document.write('<td>' + date + '</td>');
//     }
//     document.write('</tr>');
// }
// document.write('</table>');

// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('main'));

function getVirtulData() {

    // 虚拟数据
    var data = [
        ['2021-12-06', 1],
        ['2021-12-07', 2],
        ['2021-12-08', 3],
        ['2021-12-09', 4],
        ['2021-12-10', 1],
        ['2021-12-11', 2],
        ['2021-12-12', 3],
        ['2021-12-13', 4],
    ];

    return data;
}

option = {
    title: {
        top: 30,
        left: 'center',
        text: 'Done '
    },
    tooltip : {},
    // 瓦片配置，颜色
    visualMap: {
        min: 0,
        max: 24,
        type: 'piecewise',  // 分段型

        // type: 'continuous',// 连续型
        orient: 'horizontal',
        left: 'center',
        top: 65,
        color: ['#196127','#239a3b','#7bc96f','#c6e48b'], // 瓦片颜色
        textStyle: {
            color: '#000'
        },
        pieces: [ // 设置分段范围
            {gt: 3},
            {gt: 2, lte: 3},
            {gt: 1, lte: 2},
            {gt: 0, lte: 1}
        ]
    },
    // 承载瓦片的日历
    calendar: {
        top: 120,
        left: 30,
        right: 30,
        cellSize: ['auto', 13],
        range: '2021',
        itemStyle: {
            normal: {borderWidth: 0.5}
        },
        yearLabel: {show: false}
    },
    series: {
        type: 'heatmap',
        coordinateSystem: 'calendar',
        data: getVirtulData()
    }
};

// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);




