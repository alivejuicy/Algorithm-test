-- 호선, 순번, 노선, 역이름, 거리, 누계

select ROUTE, 
concat(ROUND(SUM(D_BETWEEN_DIST), 1), 'km') as TOTAL_DISTANCE,
concat(ROUND(AVG(D_BETWEEN_DIST), 2), 'km') as AVERAGE_DISTANCE
from SUBWAY_DISTANCE
group by ROUTE
order by  SUM(D_BETWEEN_DIST) DESC;