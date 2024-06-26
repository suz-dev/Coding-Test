SELECT A.ITEM_ID, A.ITEM_NAME, A.RARITY
FROM ITEM_INFO A JOIN ITEM_TREE B
ON A.ITEM_ID = B.ITEM_ID
WHERE B.PARENT_ITEM_ID IN (SELECT A.ITEM_ID
                           FROM ITEM_INFO A JOIN ITEM_TREE B
                           ON A.ITEM_ID = B.ITEM_ID
                           WHERE A.RARITY LIKE 'RARE')
ORDER BY A.ITEM_ID DESC;