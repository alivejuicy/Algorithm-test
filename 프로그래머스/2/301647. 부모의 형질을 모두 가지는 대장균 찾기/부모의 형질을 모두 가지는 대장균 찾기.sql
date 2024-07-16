-- id, parent_id, size_of_colony, DIFFERENTIATION_DATE, GENOTYPE 
-- id, 부모id, 크기, 분화날짜, 형질

select B.id, B.genotype, A.genotype parent_genotype from 
ECOLI_DATA A left join ECOLI_DATA B on A.id = B.parent_id
-- B 테이블의 ID : 자식아이디
where 1=1
and A.genotype & B.genotype = A.genotype  -- 비트연산
order by B.id