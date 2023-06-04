{\rtf1\ansi\ansicpg949\cocoartf2709
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fnil\fcharset0 Menlo-Bold;\f1\fnil\fcharset0 Menlo-Regular;}
{\colortbl;\red255\green255\blue255;\red115\green158\blue202;\red170\green170\blue170;\red158\green158\blue158;
\red193\green170\blue108;\red192\green192\blue192;\red238\green204\blue100;\red202\green197\blue128;\red102\green151\blue104;
}
{\*\expandedcolortbl;;\csgenericrgb\c45098\c61961\c79216;\csgenericrgb\c66667\c66667\c66667;\csgenericrgb\c61961\c61961\c61961;
\csgenericrgb\c75686\c66667\c42353;\csgenericrgb\c75294\c75294\c75294;\csgenericrgb\c93333\c80000\c39216;\csgenericrgb\c79216\c77255\c50196;\csgenericrgb\c40000\c59216\c40784;
}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\b\fs24 \cf2 CREATE
\f1\b0 \cf3  
\f0\b \cf2 TABLE
\f1\b0 \cf3  \cf4 board\cf3  (\cf0 \
\cf3   \cf4 id\cf3  
\f0\b \cf5 INT
\f1\b0 \cf3  
\f0\b \cf2 AUTO_INCREMENT
\f1\b0 \cf3  
\f0\b \cf2 PRIMARY
\f1\b0 \cf3  
\f0\b \cf2 KEY
\f1\b0 \cf3 ,\cf0 \
\cf3   \cf4 title\cf3  
\f0\b \cf5 VARCHAR
\f1\b0 \cf3 (\cf6 255\cf3 ) 
\f0\b \cf2 NOT
\f1\b0 \cf3  
\f0\b \cf2 NULL
\f1\b0 \cf3 ,\cf0 \
\cf3   \cf4 author\cf3  
\f0\b \cf5 VARCHAR
\f1\b0 \cf3 (\cf6 255\cf3 ) 
\f0\b \cf2 NOT
\f1\b0 \cf3  
\f0\b \cf2 NULL
\f1\b0 \cf3 ,\cf0 \
\cf3   \cf4 content\cf3  
\f0\b \cf5 TEXT
\f1\b0 \cf3  
\f0\b \cf2 NOT
\f1\b0 \cf3  
\f0\b \cf2 NULL
\f1\b0 \cf3 ,\cf0 \
\cf3   \cf4 created_at\cf3  
\f0\b \cf5 DATETIME
\f1\b0 \cf3  
\f0\b \cf2 NOT
\f1\b0 \cf3  
\f0\b \cf2 NULL
\f1\b0 \cf3 ,\cf0 \
\cf3   \cf4 is_deletable\cf3  
\f0\b \cf2 BOOLEAN
\f1\b0 \cf3  
\f0\b \cf2 NOT
\f1\b0 \cf3  
\f0\b \cf2 NULL
\f1\b0 \cf3  
\f0\b \cf2 DEFAULT
\f1\b0 \cf3  
\f0\b \cf2 true
\f1\b0 \cf0 \
\cf3 )\cf7 ;\cf0 \
\

\f0\b \cf2 CREATE
\f1\b0 \cf3  
\f0\b \cf2 TABLE
\f1\b0 \cf3  \cf4 boardDetail\cf3  (\cf0 \
\cf3   \cf4 id\cf3  
\f0\b \cf5 INT
\f1\b0 \cf3  
\f0\b \cf2 PRIMARY
\f1\b0 \cf3  
\f0\b \cf2 KEY
\f1\b0 \cf3 ,\cf0 \
\cf3   \cf4 detail_text\cf3  
\f0\b \cf5 TEXT
\f1\b0 \cf3  
\f0\b \cf2 NOT
\f1\b0 \cf3  
\f0\b \cf2 NULL
\f1\b0 \cf0 \
\cf3 )\cf7 ;\cf0 \
\

\f0\b \cf2 INSERT
\f1\b0 \cf3  
\f0\b \cf2 INTO
\f1\b0 \cf3  \cf4 board\cf3  (\cf4 title\cf3 , \cf4 author\cf3 , \cf4 content\cf3 , \cf4 created_at\cf3 , \cf4 is_deletable\cf3 )\cf0 \

\f0\b \cf2 VALUES
\f1\b0 \cf0 \
\cf3   (\cf8 '\uc0\u52395  \u48264 \u51704  \u44172 \u49884 \u47932 '\cf3 , \cf8 '\uc0\u51089 \u49457 \u51088 1'\cf3 , \cf8 '\uc0\u52395  \u48264 \u51704  \u44172 \u49884 \u47932 \u51032  \u45236 \u50857 \u51077 \u45768 \u45796 .'\cf3 , \cf8 '2023-05-01 10:00:00'\cf3 , 
\f0\b \cf2 true
\f1\b0 \cf3 ),\cf0 \
\cf3   (\cf8 '\uc0\u46160  \u48264 \u51704  \u44172 \u49884 \u47932 '\cf3 , \cf8 '\uc0\u51089 \u49457 \u51088 2'\cf3 , \cf8 '\uc0\u46160  \u48264 \u51704  \u44172 \u49884 \u47932 \u51032  \u45236 \u50857 \u51077 \u45768 \u45796 .'\cf3 , \cf8 '2023-05-02 11:30:00'\cf3 , 
\f0\b \cf2 true
\f1\b0 \cf3 ),\cf0 \
\cf3   (\cf8 '\uc0\u49464  \u48264 \u51704  \u44172 \u49884 \u47932 '\cf3 , \cf8 '\uc0\u51089 \u49457 \u51088 3'\cf3 , \cf8 '\uc0\u49464  \u48264 \u51704  \u44172 \u49884 \u47932 \u51032  \u45236 \u50857 \u51077 \u45768 \u45796 .'\cf3 , \cf8 '2023-05-03 14:15:00'\cf3 , 
\f0\b \cf2 true
\f1\b0 \cf3 ),\cf0 \
\cf3   (\cf8 '\uc0\u45348  \u48264 \u51704  \u44172 \u49884 \u47932 '\cf3 , \cf8 '\uc0\u51089 \u49457 \u51088 4'\cf3 , \cf8 '\uc0\u45348  \u48264 \u51704  \u44172 \u49884 \u47932 \u51032  \u45236 \u50857 \u51077 \u45768 \u45796 .'\cf3 , \cf8 '2023-05-04 16:45:00'\cf3 , 
\f0\b \cf2 false
\f1\b0 \cf3 ),\cf0 \
\cf3   (\cf8 '\uc0\u45796 \u49455  \u48264 \u51704  \u44172 \u49884 \u47932 '\cf3 , \cf8 '\uc0\u51089 \u49457 \u51088 5'\cf3 , \cf8 '\uc0\u45796 \u49455  \u48264 \u51704  \u44172 \u49884 \u47932 \u51032  \u45236 \u50857 \u51077 \u45768 \u45796 .'\cf3 , \cf8 '2023-05-05 09:20:00'\cf3 , 
\f0\b \cf2 true
\f1\b0 \cf3 )\cf7 ;\cf0 \
\cf3   \cf0 \
\cf9 -- \uc0\u45908 \u48120  \u45936 \u51060 \u53552  \u49341 \u51077 \cf0 \

\f0\b \cf2 INSERT
\f1\b0 \cf3  
\f0\b \cf2 INTO
\f1\b0 \cf3  \cf4 boardDetail\cf3  (\cf4 id\cf3 , \cf4 detail_text\cf3 )\cf0 \

\f0\b \cf2 VALUES
\f1\b0 \cf0 \
\cf3   (\cf6 1\cf3 , \cf8 '\uc0\u52395  \u48264 \u51704  \u44172 \u49884 \u47932 \u51032  \u49345 \u49464  \u45236 \u50857 \u51077 \u45768 \u45796 .'\cf3 ),\cf0 \
\cf3   (\cf6 2\cf3 , \cf8 '\uc0\u46160  \u48264 \u51704  \u44172 \u49884 \u47932 \u51032  \u49345 \u49464  \u45236 \u50857 \u51077 \u45768 \u45796 .'\cf3 ),\cf0 \
\cf3   (\cf6 3\cf3 , \cf8 '\uc0\u49464  \u48264 \u51704  \u44172 \u49884 \u47932 \u51032  \u49345 \u49464  \u45236 \u50857 \u51077 \u45768 \u45796 .'\cf3 ),\cf0 \
\cf3   (\cf6 4\cf3 , \cf8 '\uc0\u45348  \u48264 \u51704  \u44172 \u49884 \u47932 \u51032  \u49345 \u49464  \u45236 \u50857 \u51077 \u45768 \u45796 .'\cf3 ),\cf0 \
\cf3   (\cf6 5\cf3 , \cf8 '\uc0\u45796 \u49455  \u48264 \u51704  \u44172 \u49884 \u47932 \u51032  \u49345 \u49464  \u45236 \u50857 \u51077 \u45768 \u45796 .'\cf3 )\cf7 ;\cf0 \
\cf3   \cf0 \
\cf3  
\f0\b \cf2 commit
\f1\b0 \cf7 ;\cf0 \
\cf3  \cf0 \

\f0\b \cf2 select
\f1\b0 \cf3  * 
\f0\b \cf2 from
\f1\b0 \cf3  \cf4 board\cf7 ;\cf0 \

\f0\b \cf2 select
\f1\b0 \cf3  * 
\f0\b \cf2 from
\f1\b0 \cf3  \cf4 boardDetail\cf7 ;}