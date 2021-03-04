insert into country (name, description, average_temperature, image_url)
values ('Greece',
        'Greece, also known as Hellas, and officially the Hellenic Republic, is a country located in Southeast Europe. Its population is approximately 10.7 million as of 2018; Athens is its largest and capital city, followed by Thessaloniki. Situated on the southern tip of the Balkans, Greece is located at the crossroads of Europe, Asia, and Africa.',
        20.5,
        'https://images.unsplash.com/photo-1555993539-1732b0258235?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1350&q=80'),
       ('Italy',
        'Italy, officially the Italian Republic, is a country consisting of a peninsula delimited by the Alps and several islands surrounding it. Italy is located in Southern Europe, and is also considered part of Western Europe.',
        18,
        'https://images.unsplash.com/photo-1526026697130-3f870884a6e3?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80');

insert into region (name, description, image_url)
values ('Crete',
        'Crete is the largest and most populous of the Greek islands, the 88th largest island in the world and the fifth largest island in the Mediterranean Sea, after Sicily, Sardinia, Cyprus and Corsica. It bounds the southern border of the Aegean Sea. Crete rests approximately 160 km (99 mi) south of the Greek mainland. It has an area of 8,336 km2 (3,219 sq mi) and a coastline of 1,046 km (650 mi).',
        'https://images.unsplash.com/photo-1470497409162-889ff0ac5726?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1050&q=80');

insert into city (name, description, image_url)
values ('Athens',
        'Athens is the capital and largest city of Greece. Athens dominates the Attica region and is one of the worlds oldest cities, with its recorded history spanning over 3,400 years and its earliest human presence started somewhere between the 11th and 7th millennium BC.',
        'https://images.unsplash.com/photo-1507475380673-1246fa72eeea?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1050&q=80'),
       ('Rome',
        'Rome, as well as the capital of the Lazio region. The city has been a major human settlement for almost three millennia. With 2,860,009 residents in 1,285 km2 (496.1 sq mi), it is also the countrys most populated comune. It is the third most populous city in the European Union by population within city limits. It is the centre of the Metropolitan City of Rome, which has a population of 4,355,725 residents, thus making it the most populous metropolitan city in Italy.',
        'https://images.unsplash.com/photo-1529260830199-42c24126f198?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1055&q=80'),
       ('Venice',
        'Venice is a city in northeastern Italy and the capital of the Veneto region. It is on a group of 118 small islands that are separated by canals and linked by over 400 bridges. The islands are in the shallow Venetian Lagoon, an enclosed bay lying between the mouths of the Po and the Piave rivers (more exactly between the Brenta and the Sile).',
        'https://images.unsplash.com/photo-1545157000-85f257f7b040?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80');

insert into user (username, password)
values ('admin', '{noop}admin'),
       ('user', '{noop}user');

insert into user_role (user_id, role)
values (1, 'ROLE_ADMIN'),
       (2, 'ROLE_USER');