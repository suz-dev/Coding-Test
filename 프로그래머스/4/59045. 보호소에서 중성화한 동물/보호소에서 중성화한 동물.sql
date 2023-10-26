SELECT 
ai.animal_id
, ai.animal_type
, ai.name
FROM animal_ins AS ai
LEFT JOIN animal_outs AS ao USING(animal_id)
WHERE ai.SEX_UPON_INTAKE != ao.SEX_UPON_OUTCOME
ORDER BY 1
;