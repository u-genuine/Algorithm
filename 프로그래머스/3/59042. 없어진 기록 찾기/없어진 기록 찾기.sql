SELECT ANIMAL_ID, NAME
FROM ANIMAL_OUTS
WHERE ANIMAL_ID NOT IN (SELECT o.ANIMAL_ID
                        FROM ANIMAL_OUTS o
                        JOIN ANIMAl_INS i
                        ON o.ANIMAL_ID = i.ANIMAL_ID);