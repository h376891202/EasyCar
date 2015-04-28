//
//  LoginView.m
//  智睿达客户端
//
//  Created by tony1220 on 15/4/27.
//  Copyright (c) 2015年 tony1220. All rights reserved.
//

#import "LoginView.h"

@implementation LoginView

- (void)awakeFromNib
{
    [_backButton setImage:IMAGE(@"narrow.png") forState:UIControlStateNormal];
    [_backButton setButtonImageStyle];
    [_phoneView setLayerType];
    [_passwordView setLayerType];
}

/*
// Only override drawRect: if you perform custom drawing.
// An empty implementation adversely affects performance during animation.
- (void)drawRect:(CGRect)rect {
    // Drawing code
}
*/

@end
