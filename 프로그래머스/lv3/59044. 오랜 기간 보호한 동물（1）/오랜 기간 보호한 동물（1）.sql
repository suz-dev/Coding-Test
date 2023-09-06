SELECT
animal_ins.name
, animal_ins.datetime
FROM animal_ins
LEFT JOIN animal_outs USING(animal_id)
WHERE animal_outs.animal_id IS NULL
ORDER BY 2 LIMIT 3
;