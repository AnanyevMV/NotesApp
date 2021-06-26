INSERT INTO notes (name, note, creation_date) VALUES (
'Заметка # 1', 'Это тестовая заметка # 1.', current_date
);

INSERT INTO hashtags (note_id, hashtag) VALUES (1, '#note'), (1, '#заметка'),
 (1, '#важно');

INSERT INTO notes(name, note, creation_date) VALUES (
'Лист покупок в магазине', 'Купить: 1) яйца 2) творог 3) хлеб 4) печенье 5) молоко 6) курица', '2021-06-24'
);

INSERT INTO hashtags (note_id, hashtag) VALUES (2, '#магазин'), (2,'#купить'), (2, '#продукты'), (2, '#note');

INSERT INTO notes(name, note, creation_date) VALUES (
'Встреча', 'Через неделю в 15:00 важная встреча по работе', '2021-06-21'
);

INSERT INTO hashtags (note_id, hashtag) VALUES (3, '#важно'), (3,'#работа'), (3, '#заметка');

INSERT INTO notes(name, note, creation_date) VALUES (
'NO HASHTAG', 'Заметка без хэштегов', current_date
);