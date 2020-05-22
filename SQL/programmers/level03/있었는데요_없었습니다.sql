/* 동물의 보호 시작일보다 입양일이 더 빠른(= 실수로 잘못 입력된) 동물의 아이디와 이름을 조회하는 SQL문을 작성하시오 */
-- JOIN
-- MySQL

SELECT i.ANIMAL_ID, i.NAME
FROM ANIMAL_INS AS i
JOIN ANIMAL_OUTS AS o
ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE o.DATETIME < i.DATETIME
ORDER BY i.DATETIME asc;