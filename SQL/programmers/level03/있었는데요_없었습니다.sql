/* ������ ��ȣ �����Ϻ��� �Ծ����� �� ����(= �Ǽ��� �߸� �Էµ�) ������ ���̵�� �̸��� ��ȸ�ϴ� SQL���� �ۼ��Ͻÿ� */
-- JOIN
-- MySQL

SELECT i.ANIMAL_ID, i.NAME
FROM ANIMAL_INS AS i
JOIN ANIMAL_OUTS AS o
ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE o.DATETIME < i.DATETIME
ORDER BY i.DATETIME asc;