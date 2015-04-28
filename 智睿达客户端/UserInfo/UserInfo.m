//
//  UserInfo.m
//  智睿达客户端
//
//  Created by tony1220 on 15/4/27.
//  Copyright (c) 2015年 tony1220. All rights reserved.
//

#import "UserInfo.h"

static UserInfo *userInfo = nil;

@implementation UserInfo

+ (UserInfo *)defaultUserInfo
{
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken ,^{
        userInfo = [[UserInfo alloc]init];
    });
    return userInfo;
}

- (instancetype)init
{
    self = [self init];
    if (self) {
        _isLogin = NO;
    }
    return self;
}

@end
