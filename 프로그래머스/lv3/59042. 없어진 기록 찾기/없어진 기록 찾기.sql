SELECT
animal_outs.ANIMAL_ID
, animal_outs.NAME
FROM animal_outs
LEFT JOIN animal_ins 
ON animal_outs.ANIMAL_ID = animal_ins.ANIMAL_ID
WHERE animal_ins.ANIMAL_ID IS NULL
ORDER BY 1
;