/* 테이블에서 고양이와 개가 각각 몇 마리인지 조회하는 SQL문을 작성하시오. (고양이를 개보다 먼저 조회할 것)*/
-- GROUP BY

SELECT ANIMAL_TYPE, COUNT(*) AS count FROM ANIMAL_INS GROUP BY ANIMAL_TYPE;