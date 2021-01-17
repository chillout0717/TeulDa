// DiaryMapper.xml 작성 전 연습해본 예제

// add diary

insert 
into diary (diary_id, title, diary_addr, latitude, longitude, diary_date, origin_nick, start_date, end_date, 
            content, thumbnail, group_id,
            currency, trans_bill, room_bill, food_bill, tour_bill, shop_bill, is_public)
values (seq_diary_diary_id.nextval, '제목', '서울시 강서구', '36.541235', '79.35489', sysdate, 'king주원', '20210115', '20210116', 
        '안녕!', 'a.jpg' ,  (select group_id
                            from groups
                            where nickname='king주원' and group_name = 'default2'),
        '달러', 20000, 30000, 40000, 50000, 60000, 'f');

// add hashtag 

insert
into hashtag (hashtag_id, diary_id, hashtag_name)
values (seq_hashtag_hashtag_id.nextval, 
            (SELECT diary_id 
            FROM
            (SELECT * 
            FROM diary 
            where origin_nick = 'king주원'
            ORDER BY diary_id desc)
            WHERE ROWNUM = 1),
        '겨울여행');

// add Photo 

insert
into photo (photo_id, diary_id, 
            photo_name, description, diary_photo_type)
values (seq_photo_photo_id.nextval, (SELECT diary_id 
                                    FROM
                                    (SELECT * 
                                    FROM diary 
                                    where origin_nick = 'king주원'
                                    ORDER BY diary_id desc)
                                    WHERE ROWNUM = 1),
        'a.jpg', '너무 춥다!', 'd')

// add hashtag랑 add Photo 할 때 기록번호를 알 수 없음. 
// 그러므로 가장 최근에 내가 작성한 기록번호 가져오는 Query가 있어야 함! 

SELECT diary_id 
FROM
(SELECT * 
FROM diary 
where origin_nick = 'king주원'
ORDER BY diary_id desc)
WHERE ROWNUM = 1

// add diary group

INSERT 
INTO groups (group_id, group_name, nickname, group_type)
VALUES (seq_groups_group_id.nextval, '겨울여행', 'king주원', '2')

// get diary 

select * 
from diary
where diary_id = 10006

// get hashtag list

select *
from hashtag
where diary_id = 10040

// get photo list

SELECT * 
FROM PHOTO
WHERE diary_id = 10041

// update diary

UPDATE diary
SET title = '변경한 기록 제목!',
    diary_addr = '부산 광안리',
    latitude = 59.6784712535,
    longitude = 946.5845321,
    last_update_date = sysdate, 
    start_date = '21-01-17',
    end_date = '21-01-18',
    content = '변경한 기록 내용~~!!',
    thumbnail = 'update.jpg',
    currency = '위안',
    trans_bill = '10000',
    room_bill = '20000',
    food_bill = '30000',
    tour_bill = '40000',
    shop_bill = '50000',
    is_public = 'f'
WHERE diary_id = 10038