//
//  UserInfo.h
//  智睿达客户端
//
//  Created by tony1220 on 15/4/27.
//  Copyright (c) 2015年 tony1220. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface UserInfo : NSObject

@property(nonatomic) BOOL isLogin;


+(UserInfo *)defaultUserInfo;

@end
