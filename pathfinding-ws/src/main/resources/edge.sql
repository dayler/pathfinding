create table edge(node_id_a integer not null,
                  node_id_b integer not null,
                  distance integer not null,
                  primary key(node_id_a,node_id_b));